package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "medicalfacilities")
public class CoSoYTe {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicalFacilityId;

    
    private String facilityName;

    private String address;

    private String contactInfo;
    
    private String img;
  
}
