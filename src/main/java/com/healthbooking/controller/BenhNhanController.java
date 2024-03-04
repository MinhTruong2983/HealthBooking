package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.healthbooking.dao.BenhNhanDao;
import com.healthbooking.entity.BenhNhan;

import javax.validation.Valid;

@Controller
public class BenhNhanController {

	@Autowired
	private BenhNhanDao benhNhanDao;

	@GetMapping("/HealthBooking/trang-ca-nhan")
	public String profile(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		BenhNhan benhNhan = benhNhanDao.findByEmail(username);
		model.addAttribute("bn", benhNhan);
		return "layout/trang-ca-nhan";
	}

	@GetMapping("/HealthBooking/danh-sach/benh-nhan/{patientsID}")
	public BenhNhan getOne(@PathVariable("patientsID") int patientsID ) {
		return benhNhanDao.findById(patientsID).get();
	}

//	@GetMapping("/HealthBooking/danh-sach/benh-nhan")
//	public List<BenhNhan> getAll() {
// 		return benhNhanDao.findAll();
//	}
//
//	@GetMapping("/HealthBooking/danh-sach/benh-nhan/{patientsID}")
//	public BenhNhan getOne(@PathVariable("patientsID") int patientsID ) {
//		return benhNhanDao.findById(patientsID).get();
//	}
	
	
}
