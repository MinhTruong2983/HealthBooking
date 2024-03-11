package com.healthbooking.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.healthbooking.dao.CoSoYTeDao;
import com.healthbooking.dao.LichHenDao;
import com.healthbooking.entity.BenhNhan;
import com.healthbooking.entity.CoSoYTe;
import com.healthbooking.entity.LichHen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.LichTrinh;
import com.healthbooking.service.SessionService;




@Controller
public class BacSiController {

	@Autowired
	SessionService service;
	
	@Autowired
	BacSiDao doctorDao;
	
	@Autowired
	LichHenDao lichHenDao;

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
			    
			  
			    List<LichTrinh> lichTrinhList = 
			    	lichTrinhDao.findByNgayLamViecAndMaBacSiAndTrangThai(ngayLamViec, doctor, "Trống");
			    
			    doctor.setLichTrinh(lichTrinhList);

			    
		   }else {
			   
			// Lấy ngày sau 7 ngày từ ngày hiện tại
			   LocalDate currentDate = LocalDate.now();
			   LocalDate endDate = currentDate.plusDays(7);

			   List<LichTrinh> lichTrinhList7NgayTrangThaiTrong = lichTrinhDao.findByMaBacSiAndTrangThai(doctor, "Trống");

			// Lọc danh sách lịch trình để chỉ giữ lại những ngày nằm trong khoảng từ ngày hiện tại đến 7 ngày sau
			lichTrinhList7NgayTrangThaiTrong = lichTrinhList7NgayTrangThaiTrong.stream()
			    .filter(lichTrinh -> lichTrinh.getNgayLamViec().isAfter(currentDate) && lichTrinh.getNgayLamViec().isBefore(endDate))
			    .collect(Collectors.toList());

			doctor.setLichTrinh(lichTrinhList7NgayTrangThaiTrong);

		
		}   
		     Set<String> upcomingDays = getUpcomingDaysFromLichTrinh(lichTrinhs);
		   
		      model.addAttribute("bacsichuyenkhoa" , doctor);   
		      
		      model.addAttribute("listUniqueNgays", upcomingDays);

		 return "layout/bacsichitiet";
	}


	
	
	public Set<String> getUpcomingDaysFromLichTrinh(List<LichTrinh> lichTrinhs) {
	    Set<String> upcomingDays = new TreeSet<>();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", new Locale("vi"));

	    LocalDate currentDate = LocalDate.now();
	    LocalDate endDate = currentDate.plusDays(7);

	    for (LichTrinh lichTrinh : lichTrinhs) {
	        LocalDate ngayLamViec = lichTrinh.getNgayLamViec();

	        // Kiểm tra xem ngày từ thuộc tính ngayLamViec có nằm trong khoảng 7 ngày từ ngày hiện tại không
	        if (ngayLamViec.isAfter(currentDate) && ngayLamViec.isBefore(endDate)) {
	            upcomingDays.add(ngayLamViec.format(formatter));
	        }
	    }

	    return upcomingDays;
	}
	
	
	@GetMapping("/HealthBooking/admin/bac-si/lichhen")
	public String bacsilichhen( Model model ) {
		
		// Lấy đối tượng Authentication từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
		
		List<LichHen> lichHen = lichHenDao.findByMaLichTrinh_MaBacSi_Email(username);
	
		  model.addAttribute("lichHens", lichHen);
		
 	return "layout/bac-si/danhsachbacsi";
	}

	
	 @GetMapping("/HealthBooking/admin/bac-si/{lichHenId}")
	public String bacsiHosothaydoi( Model model ,@PathVariable("lichHenId") int lichHenId, @RequestParam("TrangThai") String trangThai,@RequestParam(name = "lidohuy", required = false) String lidohuy) {
		
	LichHen lichHen = lichHenDao.findById(lichHenId).get();
		
	lichHen.setTrangThai(trangThai);
	
	lichHen.setLidohuy(lidohuy);
	
	lichHenDao.save(lichHen);

		
 	return "redirect:/HealthBooking/admin/bac-si/lichhen";
	}
	

	 
	 @GetMapping("/HealthBooking/admin/bac-si/hoso")
		public String bacsiHoso( Model model ) {
			
			// Lấy đối tượng Authentication từ SecurityContextHolder
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        String username = authentication.getName();
	        
	    
			BacSi bacSi = doctorDao.findByEmail(username);
			
			System.out.println(bacSi);
		
			model.addAttribute("bacSi", bacSi);
			
	 	return "layout/bac-si/trang-ca-nhan";
		}
	 
	 
	 @GetMapping("/HealthBooking/admin/bac-si/lichtrinh")
		public String bacsilichtriinh( Model model ) {
			
			// Lấy đối tượng Authentication từ SecurityContextHolder
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        String username = authentication.getName();
	        
	    
			BacSi bacSi = doctorDao.findByEmail(username);
			
			Set<String> upcomingDays = getUpcomingDaysFromLichTrinh(bacSi.getLichTrinh());
			   

		    model.addAttribute("listUniqueNgays", upcomingDays);
		
//		    List<LichTrinh> lichTrinhs = doctorDao.findby
		     
			model.addAttribute("bacSi", bacSi);
			
			LichTrinh lichTrinh = new LichTrinh();
			
			model.addAttribute("lichTrinh", lichTrinh);
			
	 	return "layout/bac-si/lichtrinh";
		}
	
	 
	 @GetMapping("/HealthBooking/admin/bac-si/lichtrinh/{bacsi}")
		public String getlichtrinhbacsi( Model model , @PathVariable("bacsi") int doctorID , @RequestParam(name = "ngay", required = false) String ngay) {
			
			BacSi doctor = doctorDao.findById(doctorID).get();
			
			 List<LichTrinh> lichTrinhs = doctor.getLichTrinh();
			 
			    // Chuyển ngày từ String sang LocalDate
			   if (ngay != null) {

				   
				    LocalDate ngayLamViec = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				    List<LichTrinh> lichTrinhList = 
				    	lichTrinhDao.findByNgayLamViecAndMaBacSi(ngayLamViec, doctor);
				    
				    doctor.setLichTrinh(lichTrinhList);

				    
			   }else {
				   
				// Lấy ngày sau 7 ngày từ ngày hiện tại
				   LocalDate currentDate = LocalDate.now();
				   LocalDate endDate = currentDate.plusDays(7);

				   List<LichTrinh> lichTrinhList7NgayTrangThaiTrong = lichTrinhDao.findByMaBacSiAndTrangThai(doctor, "Trống");

				// Lọc danh sách lịch trình để chỉ giữ lại những ngày nằm trong khoảng từ ngày hiện tại đến 7 ngày sau
				lichTrinhList7NgayTrangThaiTrong = lichTrinhList7NgayTrangThaiTrong.stream()
				    .filter(lichTrinh -> lichTrinh.getNgayLamViec().isAfter(currentDate) && lichTrinh.getNgayLamViec().isBefore(endDate))
				    .collect(Collectors.toList());

				doctor.setLichTrinh(lichTrinhList7NgayTrangThaiTrong);

			
			}   
			     Set<String> upcomingDays = getUpcomingDaysFromLichTrinh(lichTrinhs);
			   
			      model.addAttribute("bacSi" , doctor);   
			      
			      LichTrinh lichTrinh = new LichTrinh();
			      
			      model.addAttribute("lichTrinh", lichTrinh);
			      
			      model.addAttribute("listUniqueNgays", upcomingDays);

			      return "layout/bac-si/lichtrinh";
		}
	 
	 
	 
	 @GetMapping("/HealthBooking/admin/bac-si/lichtrinh/{id}/{bacsi}")
		public String bacsilichtriinhthaydoi( Model model, @PathVariable("bacsi") int doctorID 
				,@PathVariable("id") int id
				) {
			
			// Lấy đối tượng Authentication từ SecurityContextHolder
	         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	         String username = authentication.getName();
	        
			 BacSi bacSi = doctorDao.findByEmail(username);
			 
			 LichTrinh lichTrinh = lichTrinhDao.getById(id);
			
	        LocalDate ngay = lichTrinh.getNgayLamViec();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String ngayString = ngay.format(formatter);
			 
			Set<String> upcomingDays = getUpcomingDaysFromLichTrinh(bacSi.getLichTrinh());
		
			
		    LocalDate ngayLamViec = LocalDate.parse(ngayString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				
				 List<LichTrinh> lichTrinhList = 
					    	lichTrinhDao.findByNgayLamViecAndMaBacSi(ngayLamViec, bacSi );
				
					
					model.addAttribute("lichTrinh", lichTrinh);
					    
					    bacSi.setLichTrinh(lichTrinhList);

		    
		    model.addAttribute("listUniqueNgays", upcomingDays);
		
			model.addAttribute("bacSi", bacSi);
			
	 	return "layout/bac-si/lichtrinh";
		}


	 @GetMapping("/HealthBooking/admin/bac-si/lichtrinh/trangthai/{id}")
		public String bacsilichtriinhthaydoitrangthai( Model model, 
				    @PathVariable("id") int id,
			        @RequestParam(name = "trangThai", defaultValue = "") String trangThai) {
			// Lấy đối tượng Authentication từ SecurityContextHolder
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         String username = authentication.getName();
        
		 BacSi bacSi = doctorDao.findByEmail(username);
		 
		 LichTrinh lichTrinh = lichTrinhDao.getById(id);
		 
		 lichTrinh.setTrangThai(trangThai);
		 
		 lichTrinhDao.save(lichTrinh);
		
		 int maBacSiInt = bacSi.getMaBacSi();
		 
		 String bacsi = String.valueOf(maBacSiInt);

		 
	   return "redirect:/HealthBooking/admin/bac-si/lichtrinh/" + id + "/" + bacsi;

	 }
	 
	 
	 
	 
	 @GetMapping("/HealthBooking/admin/bac-si/lichtrinh/taolichtrinh")
		public String bacsitaolichtrinh( Model model) {
			// Lấy đối tượng Authentication từ SecurityContextHolder
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         String username = authentication.getName();
     
		 BacSi bacSi = doctorDao.findByEmail(username);
		 
		 int maBacSiInt = bacSi.getMaBacSi();
		 
		 String bacsi = String.valueOf(maBacSiInt);
		 
		// Lấy ngày sau 7 ngày từ ngày hiện tại
		 LocalDate currentDate = LocalDate.now();
		 LocalDate endDate = currentDate.plusDays(7);

		 // Kiểm tra và tạo lịch trình cho từng ngày
		 for (LocalDate ngayLamViec = currentDate; ngayLamViec.isBefore(endDate); ngayLamViec = ngayLamViec.plusDays(1)) {
		     // Lấy danh sách lịch trình cho ngày hiện tại
		     List<LichTrinh> lichTrinhList = lichTrinhDao.findByNgayLamViecAndMaBacSi(ngayLamViec,bacSi);

		     
		     if (lichTrinhList.isEmpty()) {
		         // Không có lịch trình cho ngày hiện tại, tạo lịch trình cho từng khoảng thời gian
		         for (LocalTime startTime = LocalTime.of(8, 0); startTime.isBefore(LocalTime.of(17, 0)); startTime = startTime.plusMinutes(30)) {
		             LocalTime endTime = startTime.plusMinutes(30);

		             // Tạo lịch trình và thêm vào cơ sở dữ liệu
		             LichTrinh newLichTrinh = new LichTrinh();
		             
		           
		             newLichTrinh.setNgayLamViec(ngayLamViec);
		             newLichTrinh.setThoigianbatdau(startTime);
		             newLichTrinh.setThoigianketthuc(endTime);
		             newLichTrinh.setTrangThai("Trống"); 
		             newLichTrinh.setMaBacSi(bacSi);
		           
		             lichTrinhDao.save(newLichTrinh);
		             
		         }
		     }
		     
		 }

		 
		 return "redirect:/HealthBooking/admin/bac-si/lichtrinh" ;

	 }
	 
	 
	 
	 
	 
	 

	
}
