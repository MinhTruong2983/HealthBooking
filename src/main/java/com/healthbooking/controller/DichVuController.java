package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.ServiceDao;
import com.healthbooking.entity.Service;

@CrossOrigin("*")
@RestController
public class ServiceController {
	@Autowired
	ServiceDao dao;
	
	@GetMapping("/HealthBooking/dich-vu-y-te")
	public List<Service> getall() {
 	return dao.findAll();
	}
	
	
	@GetMapping("/HealthBooking/dich-vu-y-te/{serviceId}")
	public Service getone(@PathVariable("serviceId") Integer serviceId ) {
		return dao.findById(serviceId).get();
	}
	
}
