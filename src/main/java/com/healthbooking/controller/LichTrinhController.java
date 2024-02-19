package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.LichTrinh;


@Controller
public class LichTrinhController {

	@Autowired
	LichTrinhDao scheduleDao;
	
	
}
