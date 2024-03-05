package com.healthbooking.controller;

import java.util.List;

import com.healthbooking.dao.LichHenDao;
import com.healthbooking.dao.LichTrinhDao;
import com.healthbooking.entity.LichHen;
import com.healthbooking.entity.LichTrinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@Autowired
	private LichHenDao lichHenDao;

	@GetMapping("/HealthBooking/trang-ca-nhan")
	public String profile(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// Kiểm tra xác thực
		if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
			String username = authentication.getName();

			// Lấy thông tin bệnh nhân dựa trên email
			BenhNhan benhNhan = benhNhanDao.findByEmail(username);

			// Kiểm tra null để tránh lỗi
			if (benhNhan != null) {
				// Lấy danh sách lịch hẹn dựa trên mã bệnh nhân
				List<LichHen> lichHens = lichHenDao.findByMaBenhNhan_Email(benhNhan.getEmail());

//              // Thêm danh sách lịch hẹn vào model
				model.addAttribute("benhNhan", benhNhan);

//                // Thêm danh sách lịch hẹn vào model
				model.addAttribute("lichHens", lichHens);

				// Trả về tên trang cá nhân (sửa lại nếu tên trang không phải "index")
				return "layout/trang-ca-nhan";
			}
		}

		// Trả về trang lỗi hoặc trang đăng nhập nếu cần
		return "redirect:/HealthBooking/login";
	}

	
	
}
