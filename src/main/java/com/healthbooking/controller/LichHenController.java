package com.healthbooking.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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
import com.vnpay.Config;
import org.springframework.web.bind.annotation.RequestParam;



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
	 public String datlichkham(Model model, @ModelAttribute LichHen lichHen) throws UnsupportedEncodingException {
		 
		 
		   if ("transfer".equals(lichHen.getThanhtoan())) {
			   String vnp_Version = "2.1.0";
		        String vnp_Command = "pay";
		        String orderType = "other";
		        
		        // Lấy thông tin người dùng đang xác thực
		         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		         String username = authentication.getName();
		         BenhNhan benhNhan = benhNhanDao.findByEmail(username);
		        
		         int maLichTrinh = service.get("maLichTrinh");
		         
		         LichTrinh lichTrinhFinal = lichTrinhDao.getById(maLichTrinh);
		       
		         LichHen lichHenFinal1 = new LichHen();
		         
		         lichHenFinal1.setThanhtoan("Chuyển Khoản");
		         
		         lichHenFinal1.setMaBenhNhan(benhNhan);
		      
		         lichHenFinal1.setMaLichTrinh(lichTrinhFinal);
		         
		         lichHenFinal1.setMieuta(lichHen.getMieuta());
		         
		         lichHenFinal1.setTrangThai("Chờ xác nhận");
		        
		        long amount = lichTrinhFinal.getMaBacSi().getGia().longValue()*100;
		        
		        lichHenFinal1.setGiakham(amount);

		        service.set("lichHenFinal1", lichHenFinal1);
		        
		        String bankCode = "NCB";
		        
		        String vnp_TxnRef = Config.getRandomNumber(8);
		        String vnp_IpAddr = "127.0.0.1";

		        String vnp_TmnCode = Config.vnp_TmnCode;
		        
		        Map<String, String> vnp_Params = new HashMap<>();
		        vnp_Params.put("vnp_Version", vnp_Version);
		        vnp_Params.put("vnp_Command", vnp_Command);
		        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		        vnp_Params.put("vnp_Amount", String.valueOf(amount));
		        vnp_Params.put("vnp_CurrCode", "VND");
		        
		        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
		        vnp_Params.put("vnp_OrderType", orderType);

		        vnp_Params.put("vnp_Locale", "vn");
		        
		        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
		        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

		        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		        String vnp_CreateDate = formatter.format(cld.getTime());
		        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
		        
		        cld.add(Calendar.MINUTE, 15);
		        String vnp_ExpireDate = formatter.format(cld.getTime());
		        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
		        
		        List fieldNames = new ArrayList(vnp_Params.keySet());
		        Collections.sort(fieldNames);
		        StringBuilder hashData = new StringBuilder();
		        StringBuilder query = new StringBuilder();
		        Iterator itr = fieldNames.iterator();
		        while (itr.hasNext()) {
		            String fieldName = (String) itr.next();
		            String fieldValue = (String) vnp_Params.get(fieldName);
		            if ((fieldValue != null) && (fieldValue.length() > 0)) {
		                //Build hash data
		                hashData.append(fieldName);
		                hashData.append('=');
		                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
		                //Build query
		                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
		                query.append('=');
		                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
		                if (itr.hasNext()) {
		                    query.append('&');
		                    hashData.append('&');
		                }
		            }
		        }
		        String queryUrl = query.toString();
		        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
		        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
			 
			 
		        return "redirect:" + paymentUrl;
		    }
		   

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
	         lichHenFinal.setTrangThai("Chờ xác nhận");
	         
	         lichHenFinal.setThanhtoan("Tiền Mặt");
	       
			 lichHenDao.save(lichHenFinal); 
	         
	         model.addAttribute("lichhen", lichHenFinal);


	         return "layout/lichkhamdadattienmat";
	     }
	 
	 
	 @GetMapping("/HealthBooking/thanhtoanthanhcong")
	 public String getThanhToanThanhCong(Model model,
	                                      @RequestParam("vnp_ResponseCode") String vnp_ResponseCode,
	                                      @RequestParam("vnp_TransactionStatus") String vnp_TransactionStatus,
	                                      @RequestParam("vnp_TxnRef") String vnp_TxnRef,
	                                      @RequestParam("vnp_Amount") String vnp_Amount,
	                                      @RequestParam("vnp_SecureHash") String vnp_SecureHash) {

				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String username = authentication.getName();
				BenhNhan benhNhan = benhNhanDao.findByEmail(username);

				int maLichTrinh = service.get("maLichTrinh");

				LichTrinh lichTrinhFinal = lichTrinhDao.getById(maLichTrinh);
				
				lichTrinhFinal.setTrangThai("Được đặt");

				LichHen lichHenFinal = service.get("lichHenFinal1");

				lichHenFinal.setMaLichTrinh(lichTrinhFinal);
				lichHenFinal.setMaBenhNhan(benhNhan);
							
				   // Giả sử bạn có một giá trị BigDecimal
		        BigDecimal giaBigDecimal = lichTrinhFinal.getMaBacSi().getGia();

		        // Chuyển đổi BigDecimal thành long bằng phương thức longValue()
				lichHenFinal.setGiakham(giaBigDecimal.longValue()); 
				
				System.out.println(lichHenFinal.getGiakham());
				
				lichHenDao.save(lichHenFinal);
				
				model.addAttribute("lichhen", lichHenFinal);
		 
			// Hiển thị trang thanh toán thành công
			return "layout/thanhtoanthanhcong";
	    
	 }

	 
	 
		
	  
}
