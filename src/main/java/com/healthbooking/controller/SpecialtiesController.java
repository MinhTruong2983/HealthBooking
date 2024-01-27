package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.SpecialtiesDao;
import com.healthbooking.entity.Service;
import com.healthbooking.entity.Specialties;

@CrossOrigin("*")
@RestController
public class SpecialtiesController {
	
	@Autowired
	SpecialtiesDao specialtiesDao;
	
	
	@GetMapping("/HealthBooking/dich-vu-y-te/kham-chuyen-khoa")
	public List<Specialties> getall() {
 	return specialtiesDao.findAll();
	}
	
	
//	@GetMapping("/HealthBooking/dich-vu-y-te/kham-chuyen-khoa/{serviceId}")
//	public Specialties getone(@PathVariable("serviceId") String specialtiesID ) {
//		return specialtiesDao.findById(specialtiesID).get();
//	}

}
