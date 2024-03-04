package com.healthbooking.controller.admin;

import com.healthbooking.dao.ChuyenKhoaDao;
import com.healthbooking.entity.BenhNhan;
import com.healthbooking.entity.ChuyenKhoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminChuyenKhoaController {

    @Autowired
    private ChuyenKhoaDao chuyenKhoaDao;

    @GetMapping("/HealthBooking/admin/chuyen-khoa/danh-sach")
    public String showAll() {
        return "layout/chuyen-khoa/danhsachchuyenkhoa";
    }
}
