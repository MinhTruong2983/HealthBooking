package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.LichTrinh;

@CrossOrigin("*")
@RestController
public class LichTrinhController {

	@Autowired
	LichTrinhDao scheduleDao;
	
	@GetMapping("/HealthBooking/lich-trinh/bac-si")
	public List<LichTrinh> getall() {
 	return scheduleDao.findAll();
	}
}
