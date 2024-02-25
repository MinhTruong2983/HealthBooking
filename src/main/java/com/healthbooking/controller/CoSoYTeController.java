package com.healthbooking.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.CoSoYTeDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.CoSoYTe;

@Controller
public class CoSoYTeController {

	
	@Autowired
	CoSoYTeDao coSoYTeDao;
	
	@Autowired
	BacSiDao bacSiDao;
	
	
	
	@GetMapping("/HealthBooking/coso-yte/danh-sach")
	public String getAll( Model model ) {
		List<CoSoYTe> listcoCoSoYTes = coSoYTeDao.findAll();
		model.addAttribute("list" ,listcoCoSoYTes );
		
		
		
 	return "layout/danhsachcosoyte";
	}
	

	@GetMapping("/HealthBooking/CoSoYTe/{maCoSoYTe}")
	public String getCoSoYTe( Model model,@PathVariable int maCoSoYTe ) {
		CoSoYTe coSoYTe = coSoYTeDao.findById(maCoSoYTe).get();

		model.addAttribute("CoSoYTe" ,coSoYTe );
		
		List<BacSi>  listBacSis = bacSiDao.findByCoSoYTe_MaCoSoYTe(maCoSoYTe);
		
		model.addAttribute("listBacSis" ,listBacSis );
		

 	return "layout/chitietcosoyte";
	}
	
	
	
	
	
}
