package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.DoctorDao;
import com.healthbooking.entity.Doctors;
import com.healthbooking.entity.Service;
import com.healthbooking.entity.Specialties;

@CrossOrigin("*")
@RestController
public class DoctorController {

	@Autowired
	DoctorDao doctorDao;
	
	
	@GetMapping("/HealthBooking/danh-sach/bac-si/danh-cho-ban")
	public List<Doctors> getAll() {
 	return doctorDao.findAll();
	}
	
	@GetMapping("/HealthBooking/dich-vu-y-te/kham-chuyen-khoa/{specialtiesID}")
	public List<Doctors> getOne(@PathVariable("specialtiesID") String specialtiesID ) {
		return doctorDao.findBySpecialtyId(specialtiesID);
	}
		
	
}
