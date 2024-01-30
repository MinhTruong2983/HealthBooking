package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.BenhNhanDao;
import com.healthbooking.entity.BenhNhan;

@CrossOrigin("*")
@RestController
public class BenhNhanController {

	@Autowired
	BenhNhanDao patientsDao;
	
	@GetMapping("/HealthBooking/danh-sach/benh-nhan")
	public List<BenhNhan> getAll() {
 	return patientsDao.findAll();
	}
	
	@GetMapping("/HealthBooking/danh-sach/benh-nhan/{patientsID}")
	public BenhNhan getOne(@PathVariable("patientsID") int patientsID ) {
		return patientsDao.findById(patientsID).get();
	}
	
	
}
