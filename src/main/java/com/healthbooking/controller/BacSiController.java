package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.entity.BacSi;




@Controller
public class BacSiController {

	@Autowired
	BacSiDao doctorDao;
	
	
	@GetMapping("/HealthBooking/danh-sach/bac-si/danh-cho-ban")
	public String getAll( Model model ) {
		List<BacSi> list = doctorDao.findAll();
		model.addAttribute("list" ,list );
		
 	return "/home/index";
	}
	
	@GetMapping("/HealthBooking/danh-sach/bac-si/{doctorID}")
	public String getDoctorID( Model model , @PathVariable("doctorID") int doctorID ) {
		BacSi doctor = doctorDao.findById(doctorID).get();
		
		model.addAttribute("doctor" , doctor);
		
 	return "/home/doctor";
	}
	
//	@GetMapping("/HealthBooking/dich-vu-y-te/kham-chuyen-khoa/{specialtiesID}")
//	public List<Doctors> getOne(@PathVariable("specialtiesID") String specialtiesID ) {
//		return doctorDao.findBySpecialtyId(specialtiesID);
//	}
		
	
}
