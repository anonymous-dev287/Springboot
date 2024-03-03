package com.padhle.GarrageSystem.Model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class BikeDetails {

	@Override
	public String toString() {
		return "BikeDetails [id=" + id + ", bikeName=" + bikeName + ", bikeType=" + bikeType + ", issueType="
				+ issueType + ", isInsurance=" + isInsurance + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bikeName;
	private String bikeType;
	private String issueType;
	private Date isInsurance;
	
	@CreationTimestamp
    private Date createdAt;
	
	//default constructor 
	public BikeDetails() {
		
	}
	
	public BikeDetails(String bikeName, String bikeType, String issueType, Date isInsurance) {
		super();
		this.bikeName = bikeName;
		this.bikeType = bikeType;
		this.issueType = issueType;
		this.isInsurance = isInsurance;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getBikeType() {
		return bikeType;
	}
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public Date getIsInsurance() {
		return isInsurance;
	}
	public void setIsInsurance(Date isInsurance) {
		this.isInsurance = isInsurance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
