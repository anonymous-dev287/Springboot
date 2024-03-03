package com.padhle.GarrageSystem.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.padhle.GarrageSystem.Model.BikeDetails;
import com.padhle.GarrageSystem.Repository.GarrageRepo;
import com.padhle.GarrageSystem.Service.BikeService;

@RestController
@RequestMapping(path = "/vehicle")
public class BikeController {

	@Autowired
	private BikeService bikeService;

	@Autowired
	private GarrageRepo repo;

	LocalDate currentDate = LocalDate.now();

	@PostMapping("/postBikeDetails")
	public ResponseEntity<?> addBikeDetails(@RequestBody BikeDetails bikedetails) {
		try {
			bikeService.repair(bikedetails.getBikeName(), bikedetails.getBikeType(), bikedetails.getIssueType(),
					bikedetails.getIsInsurance());
			return ResponseEntity.ok("Accepted : 200");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to add bike details: " + e.getMessage());
		}
	}

	//method to get All the bikes
	@GetMapping("/getBikeDeatils")
	public List<BikeDetails> getAllUsers() {

		return repo.findAll();
	}

	//Method to sort the bike based on issue types
	@GetMapping("/getBikeDetailsByIssueType")
	public Iterable<BikeDetails> getBikeDetailsByIssueType(@RequestParam("issueType") String issueType) {
		return repo.findByIssueType(issueType);
	}

	//Method to check if insurance is exist for particular bike or not
	@GetMapping("getInsuranceStatus/{Id}")
	public String getInsuranceValidity(@PathVariable int Id) {

		return bikeService.getInsuranceValidity(Id);

	}
	
}
