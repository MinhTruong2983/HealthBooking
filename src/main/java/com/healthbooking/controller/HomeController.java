package com.healthbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.BaiVietDao;
import com.healthbooking.dao.ChuyenKhoaDao;
import com.healthbooking.dao.CoSoYTeDao;
import com.healthbooking.dao.DichVuDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.BaiViet;
import com.healthbooking.entity.ChuyenKhoa;
import com.healthbooking.entity.CoSoYTe;
import com.healthbooking.entity.DichVu;



@Controller
public class HomeController {
	
	@Autowired
	DichVuDao  dichVuDao;

	@Autowired
	CoSoYTeDao coSoYTeDao ;
	
	@Autowired
	BacSiDao  bacSiDao;
	@Autowired
	ChuyenKhoaDao chuyenKhoaDao;
	
	@Autowired
	BaiVietDao baiVietDao;
	
	
    @RequestMapping("/HealthBooking")
    public String Home(Model model) {
    	
    	List<DichVu> DichVu = dichVuDao.findAll();
		model.addAttribute("DichVu" ,DichVu );
		
		
		List<ChuyenKhoa> ChuyenKhoa =  chuyenKhoaDao.findAll();
		model.addAttribute("ChuyenKhoa" ,ChuyenKhoa );
		
		List<CoSoYTe> CoSoYTe =  coSoYTeDao.findAll();
		model.addAttribute("CoSoYTe" ,CoSoYTe );
	
		List<BacSi> BacSi =  bacSiDao.findAll();
		model.addAttribute("BacSi" ,BacSi );
		
		List<BaiViet> BaiViet =  baiVietDao.findAll();
		
		model.addAttribute("BaiViet" ,BaiViet );
    	
        return "/index";
    }
    
    
    @RequestMapping("/HealthBooking/security/login/success")
    public String HomeLoginSuccess(Model model) {
    	
//    	List<DichVu> DichVu = dichVuDao.findAll();
//		model.addAttribute("DichVu" ,DichVu );
//		
//		
//		List<ChuyenKhoa> ChuyenKhoa =  chuyenKhoaDao.findAll();
//		model.addAttribute("ChuyenKhoa" ,ChuyenKhoa );
//		
//		List<CoSoYTe> CoSoYTe =  coSoYTeDao.findAll();
//		model.addAttribute("CoSoYTe" ,CoSoYTe );
//	
//		List<BacSi> BacSi =  bacSiDao.findAll();
//		model.addAttribute("BacSi" ,BacSi );
//		
//		List<BaiViet> BaiViet =  baiVietDao.findAll();
//		
//		model.addAttribute("BaiViet" ,BaiViet );
    	
		return "redirect:/HealthBooking";

    }
    
  
	
 
    
    @RequestMapping("/HealthBooking/login")
    public String Login2(Model model) {
    	
    return "layout/login";
    }
    


    
    
    @GetMapping("/security/success")
	public String logoffsuccess(Model model){
		model.addAttribute("message","Bạn đã đăng xuất :))!");
		return "layout/login";
	}
    
    @RequestMapping("/HealthBooking/logout")
    public String logout(Model model) {
    	
    return "layout/login";
    }
    
}
