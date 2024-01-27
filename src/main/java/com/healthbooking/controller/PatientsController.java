package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.PatientsDao;
import com.healthbooking.entity.Doctors;
import com.healthbooking.entity.Patients;

@CrossOrigin("*")
@RestController
public class PatientsController {

	@Autowired 
	PatientsDao patientsDao;
	
	@GetMapping("/HealthBooking/danh-sach/benh-nhan")
	public List<Patients> getAll() {
 	return patientsDao.findAll();
	}
	
	@GetMapping("/HealthBooking/danh-sach/benh-nhan/{patientsID}")
	public Patients getOne(@PathVariable("patientsID") int patientsID ) {
		return patientsDao.findById(patientsID).get();
	}
	
	
}
