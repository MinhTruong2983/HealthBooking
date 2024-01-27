package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.MedicalFacilityDao;
import com.healthbooking.entity.Doctors;
import com.healthbooking.entity.MedicalFacility;

@CrossOrigin("*")
@RestController
public class MedicalFacilityController {

	
	@Autowired
	MedicalFacilityDao medicalFacilityDao;
	
	@GetMapping("/HealthBooking/co-so-y-te")
	public List<MedicalFacility> getAll() {
 	return medicalFacilityDao.findAll();
	}
	
	@GetMapping("/HealthBooking/co-so-y-te/{medicalFacilityID}")
	public MedicalFacility getOne(@PathVariable("medicalFacilityID") int medicalFacilityID ) {
		return medicalFacilityDao.findById(medicalFacilityID).get();
	}
	
	
}
