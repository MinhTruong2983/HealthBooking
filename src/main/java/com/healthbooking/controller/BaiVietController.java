package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.BaiVietDao;
import com.healthbooking.entity.BaiViet;

@CrossOrigin("*")
@RestController
public class BaiVietController {

	@Autowired
	BaiVietDao postDao;
	
	
	@GetMapping("/HealthBooking/cam-nang")
	public List<BaiViet> getAll() {
 	return postDao.findAll();
	}
	
	
	@GetMapping("/HealthBooking/cam-nang/{PostID}")
	public BaiViet getID(@PathVariable("PostID") int PostID) {
 	return postDao.findById(PostID).get();
	}
	
	
}
