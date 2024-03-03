package com.padhle.GarrageSystem.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.padhle.GarrageSystem.Model.BikeDetails;
import com.padhle.GarrageSystem.Repository.GarrageRepo;

@Service
public class BikeService {
	

	
	@Autowired
	private GarrageRepo repo;
	
	//Add data into garage Db
	public void repair(String name, String type, String Issue, Date insurance) {
		 BikeDetails bike = new BikeDetails();
		bike.setBikeName(name);
		bike.setBikeType(type);
		bike.setIssueType(Issue);
		bike.setIsInsurance(insurance);
		
		repo.save(bike);
		
	}
	
	//Delete the data after 5 days
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteRepairedData() {
		LocalDate deliveredDate = LocalDate.now().minusDays(5);
		Iterable<BikeDetails> repairedBikeRecords = repo.findByIsInsuranceBefore(deliveredDate);
		
		for(BikeDetails b: repairedBikeRecords) {
			repo.delete(b);
		}
	}
	
    public String getInsuranceValidity(int id) {
		Optional<BikeDetails> bikes = repo.findById(id);
		if (!bikes.isPresent()) {
			return "Bike doesn't exist in garrage";
		}

		BikeDetails all_bike = bikes.get();
		int insuranceYear = all_bike.getIsInsurance().toLocalDate().getYear();
		int currentYear = LocalDate.now().getYear();

		if ((currentYear - insuranceYear) < 2) {

			return "The Insurance is valid for " + all_bike.getBikeName();
		} 
		else {
			return "The Insurance of " + all_bike.getBikeName() + "is expired ";
		}
    }
}
