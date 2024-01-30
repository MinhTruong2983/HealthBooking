package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.DichVuDao;
import com.healthbooking.entity.DichVu;

@CrossOrigin("*")
@RestController
public class DichVuController {
	@Autowired
	DichVuDao dao;
	
	@GetMapping("/HealthBooking/dich-vu-y-te")
	public List<DichVu> getall() {
 	return dao.findAll();
	}
	
	
	@GetMapping("/HealthBooking/dich-vu-y-te/{serviceId}")
	public DichVu getone(@PathVariable("serviceId") Integer serviceId ) {
		return dao.findById(serviceId).get();
	}
	
}
