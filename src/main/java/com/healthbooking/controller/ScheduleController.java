package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.ScheduleDao;
import com.healthbooking.entity.Schedule;

@CrossOrigin("*")
@RestController
public class ScheduleController {

	@Autowired
	ScheduleDao scheduleDao;
	
	@GetMapping("/HealthBooking/lich-trinh/bac-si")
	public List<Schedule> getall() {
 	return scheduleDao.findAll();
	}
}
