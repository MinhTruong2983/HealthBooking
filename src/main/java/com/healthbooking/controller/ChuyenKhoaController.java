package com.healthbooking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.ChuyenKhoaDao;
import com.healthbooking.dao.GoiKhamDao;
import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.ChuyenKhoa;
import com.healthbooking.entity.LichTrinh;

@Controller
public class ChuyenKhoaController {
	
	@Autowired
	ChuyenKhoaDao chuyenKhoaDao;
	
	@Autowired 
	BacSiDao bacSiDao;
	  
	@Autowired
	GoiKhamDao goiKhamDao;
	
	@Autowired
	LichTrinhDao lichTrinhDao;
	
    @RequestMapping("/HealthBooking/danh-sach/chuyenkhoa")
    public String lichkham(Model model) {
    	
    	List<ChuyenKhoa> listChuyenKhoas = chuyenKhoaDao.findAll();
    	
    	model.addAttribute("listChuyenKhoas",listChuyenKhoas);
    	
        return "layout/danhsachchuyenkhoa";
    }
	
    
    
    @RequestMapping("/HealthBooking/danh-sach/chuyenkhoa/{machuyenkhoa}")
    public String chitietchuyenkhoa(Model model ,@PathVariable String machuyenkhoa ,@RequestParam(name = "ngay", required = false) String ngay ) {
    	
        List<BacSi> bacSis = bacSiDao.findByMaChuyenKhoa(machuyenkhoa);

    	model.addAttribute("bacsichuyenkhoa",bacSis);
    	
        return "layout/danhsachbacsichuyenkhoa";
    }
    
    
    
    

  
	

}
