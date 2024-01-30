package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.LichHenDao;
import com.healthbooking.entity.LichHen;

@CrossOrigin("*")
@RestController
public class LichHenController {

	@Autowired
	LichHenDao appointmentsDao;
	
	@GetMapping("/HealthBooking/danh-sach/lich-kham")
	public List<LichHen> getAll() {
 	return appointmentsDao.findAll();
	}
	
	
}
