package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.PostDao;
import com.healthbooking.entity.Post;

@CrossOrigin("*")
@RestController
public class PostController {

	@Autowired
	PostDao postDao;
	
	
	@GetMapping("/HealthBooking/cam-nang")
	public List<Post> getAll() {
 	return postDao.findAll();
	}
	
	
	@GetMapping("/HealthBooking/cam-nang/{PostID}")
	public Post getID(@PathVariable("PostID") int PostID) {
 	return postDao.findById(PostID).get();
	}
	
	
}
