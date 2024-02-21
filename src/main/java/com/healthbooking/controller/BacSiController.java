package com.healthbooking.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.LichTrinh;




@Controller
public class BacSiController {

	@Autowired
	BacSiDao doctorDao;
	
	@Autowired
	LichTrinhDao lichTrinhDao;
	
//	@GetMapping("/HealthBooking/danh-sach/bac-si/danh-cho-ban")
//	public String getAll( Model model ) {
//		List<BacSi> list = doctorDao.findAll();
//		model.addAttribute("list" ,list );
//		
// 	return "/index";
//	}
	
	
	@GetMapping("HealthBooking/bacsi/{doctorID}")
	public String getDoctorID( Model model , @PathVariable("doctorID") int doctorID , @RequestParam(name = "ngay", required = false) String ngay) {
		
		   BacSi doctor = doctorDao.findById(doctorID).get();
		
		
		   Set<LocalDate> uniqueNgays = new HashSet<>();

		   List<LichTrinh> lichTrinhs = doctor.getLichTrinh();
		   
		  
		   for (LichTrinh lichTrinh : lichTrinhs) {
	            uniqueNgays.add(lichTrinh.getNgayLamViec());
	        }
		  
		   
	
		    // Chuyển ngày từ String sang LocalDate
		   if (ngay != null) {
			   
			   
			    LocalDate ngayLamViec = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			    
			    // Kiểm tra xem lịch trình của bác sĩ đã được thiết lập chưa
			    if (!doctor.getLichTrinh().isEmpty()) {
			        // Nếu đã có lịch trình, xóa lịch trình hiện tại trước khi cập nhật
			        doctor.getLichTrinh().clear();
			    }
			    
			    
			    List<LichTrinh> listLichTrinhs = lichTrinhDao.findByNgayLamViec(ngayLamViec);
			  
			    doctor.setLichTrinh(listLichTrinhs);

		   }
		   
		   
		      model.addAttribute("bacsichuyenkhoa" , doctor);
		 
		    
		      model.addAttribute("listUniqueNgays", new ArrayList<>(uniqueNgays));
 
		    
		
		 return "layout/bacsichitiet";
	}
	

	


	
}
