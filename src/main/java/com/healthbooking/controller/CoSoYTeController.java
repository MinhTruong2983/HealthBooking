package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.CoSoYTeDao;
import com.healthbooking.entity.CoSoYTe;

@CrossOrigin("*")
@RestController
public class CoSoYTeController {

	
	@Autowired
	CoSoYTeDao medicalFacilityDao;
	
	@GetMapping("/HealthBooking/co-so-y-te")
	public List<CoSoYTe> getAll() {
 	return medicalFacilityDao.findAll();
	}
	
	@GetMapping("/HealthBooking/co-so-y-te/{medicalFacilityID}")
	public CoSoYTe getOne(@PathVariable("medicalFacilityID") int medicalFacilityID ) {
		return medicalFacilityDao.findById(medicalFacilityID).get();
	}
	
	
}
