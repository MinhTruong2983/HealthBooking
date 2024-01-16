package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.AppointmentsDao;
import com.healthbooking.entity.Appointments;
import com.healthbooking.entity.Doctors;

@CrossOrigin("*")
@RestController
public class AppointmentsController {

	@Autowired
	AppointmentsDao appointmentsDao;
	
	@GetMapping("/HealthBooking/danh-sach/lich-kham")
	public List<Appointments> getAll() {
 	return appointmentsDao.findAll();
	}
	
	
}
