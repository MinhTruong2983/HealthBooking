package com.healthbooking.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import com.healthbooking.dao.CoSoYTeDao;
import com.healthbooking.entity.BenhNhan;
import com.healthbooking.entity.CoSoYTe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	CoSoYTeDao coSoYTeDao;

	@Autowired
	LichTrinhDao lichTrinhDao;
	
	@GetMapping("/HealthBooking/bac-si/danh-sach")
	public String getAll( Model model ) {
		List<BacSi> list = doctorDao.findAll();
		model.addAttribute("list" ,list );
		 // Lấy danh sách khu vực 
		List<String> listKhuVuc = new ArrayList<>(Arrays.asList("TP. Hồ Chí Minh", "Đà Nẵng", "Hà Nội"));
		model.addAttribute("listKhuVuc", listKhuVuc);
		return "layout/danhsachbacsi";
	}
	
	
	
	
	@GetMapping("/HealthBooking/bac-si/danh-sach{khuvuc}")
	public String bacsiKhuVuc( Model model ,@RequestParam(name = "khuVuc", required = false) String khuVuc) {
		List<BacSi> listBSkhuVuc = doctorDao.findByKhuVuc(khuVuc);
		System.out.println(khuVuc);
		model.addAttribute("list" ,listBSkhuVuc );
		 // Lấy danh sách khu vực 
		List<String> listKhuVuc = new ArrayList<>(Arrays.asList("TP. Hồ Chí Minh", "Đà Nẵng", "Hà Nội"));
        model.addAttribute("listKhuVuc", listKhuVuc);
	
		
 	return "layout/danhsachbacsi";
	}
	
	
	
	
	@GetMapping("HealthBooking/bacsi/{doctorID}")
	public String getDoctorID( Model model , @PathVariable("doctorID") int doctorID , @RequestParam(name = "ngay", required = false) String ngay) {
		
		BacSi doctor = doctorDao.findById(doctorID).get();
		 List<LichTrinh> lichTrinhs = doctor.getLichTrinh();
		    // Chuyển ngày từ String sang LocalDate
		   if (ngay != null) {
			    LocalDate ngayLamViec = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			  
			    List<LichTrinh> lichTrinhList = lichTrinhDao.findByNgayLamViecAndMaBacSi(ngayLamViec, doctor);
			    doctor.setLichTrinh(lichTrinhList);
		   }
		   Set<String> upcomingDays = getUpcomingDaysFromLichTrinh(lichTrinhs);
          
		      System.out.println(upcomingDays);
		   
		   
		      model.addAttribute("bacsichuyenkhoa" , doctor);    
		      
		      model.addAttribute("listUniqueNgays", upcomingDays);

		 return "layout/bacsichitiet";
	}
	
	
	
    public Set<String> getUpcomingDaysFromLichTrinh(List<LichTrinh> lichTrinhs) {
        Set<String> uniqueNgays = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", new Locale("vi"));

        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusDays(7);

        for (LichTrinh lichTrinh : lichTrinhs) {
            LocalDate ngayLamViec = lichTrinh.getNgayLamViec();

            // Kiểm tra xem ngày từ thuộc tính ngayLamViec có nằm trong khoảng 7 ngày từ ngày hiện tại không
            if (ngayLamViec.isAfter(currentDate) && ngayLamViec.isBefore(endDate)) {
                uniqueNgays.add(ngayLamViec.format(formatter));
            }
        }

        return uniqueNgays;
    }




	
}
