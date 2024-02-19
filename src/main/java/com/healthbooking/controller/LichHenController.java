package com.healthbooking.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.BenhNhanDao;
import com.healthbooking.dao.LichHenDao;
import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.BenhNhan;
import com.healthbooking.entity.ChuyenKhoa;
import com.healthbooking.entity.LichHen;
import com.healthbooking.entity.LichTrinh;
import com.healthbooking.service.SessionService;


@Controller
public class LichHenController {

	@Autowired
	BacSiDao bacSiDao;
	
	@Autowired
	LichHenDao lichHenDao;
	
	@Autowired
	LichTrinhDao lichTrinhDao;
	
	@Autowired
	SessionService service;

	@Autowired
	BenhNhanDao benhNhanDao;
  
	
	 @RequestMapping("/HealthBooking/Dat-Lich-Kham/{malichtrinh}")
	    public String lichkham(Model model ,@PathVariable int malichtrinh) {
		    
		 // Lấy đối tượng Authentication từ SecurityContextHolder
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
	        String username = authentication.getName();
	        
	        
	        BenhNhan benhNhan = benhNhanDao.findByEmail(username);

		    LichHen lichHen = new LichHen();
		    
		    lichHen.setMaBenhNhan(benhNhan);
		     
		
		 
		    model.addAttribute("thongTinDatLich", lichHen);
		  
	    	
	        LichTrinh  lichtrinh = lichTrinhDao.findById(malichtrinh).get();
	        
	      
	        int maLichTrinh = lichtrinh.getMaLichTrinh();
	       
	      
	             service.set("maLichTrinh", maLichTrinh);
	            // Lưu đối tượng vào dịch vụ
	             
	             
	    	model.addAttribute("lichtrinh",lichtrinh);
	    	
	     return "layout/datlichkham";
	    }

	 
	 @PostMapping("/HealthBooking/Dat-Lich-Kham")
	 public String datlichkham(Model model, @ModelAttribute LichHen lichHen) {
	
	         // Lấy thông tin người dùng đang xác thực
	         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	         String username = authentication.getName();
	         BenhNhan benhNhan = benhNhanDao.findByEmail(username);
	         
	         // Lấy maLichTrinh từ phiên
	         
	         int maLichTrinh = service.get("maLichTrinh");
	         
	         LichTrinh lichTrinhFinal = lichTrinhDao.getById(maLichTrinh);

	         LichHen lichHenFinal = new LichHen();
	         
	        	 
	         lichHenFinal.setMaBenhNhan(benhNhan);
	      
	         lichHenFinal.setMaLichTrinh(lichTrinhFinal);
	         
	         lichHenFinal.setMieuta(lichHen.getMieuta());
	         lichHenFinal.setTrangThai("Chờ xác nhận!");
	         
	         System.out.println(lichHenFinal);
	       
	         lichHenDao.save(lichHenFinal);
	         
	         model.addAttribute("lichhen", lichHenFinal);

	         return "layout/lichkhamdadat";
	       
	 

	     }
	  
}
