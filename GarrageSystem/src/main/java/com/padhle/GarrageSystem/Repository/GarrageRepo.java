package com.padhle.GarrageSystem.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padhle.GarrageSystem.Model.BikeDetails;

@Repository
public interface GarrageRepo extends JpaRepository<BikeDetails, Integer>{
	
	//Manually create repos
	Iterable<BikeDetails> findByIssueType(String issueType);
	
	Iterable<BikeDetails> findByIsInsuranceBefore(LocalDate date);


}
