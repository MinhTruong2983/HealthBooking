package com.healthbooking.controller.admin;

import com.healthbooking.dao.ChuyenKhoaDao;
import com.healthbooking.dao.CoSoYTeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminCoSoyTeController {

    @Autowired
    private CoSoYTeDao coSoYTeDao;

    @GetMapping("/HealthBooking/admin/co-so-y-te/danh-sach")
    public String showAll() {
        return "layout/co-so-y-te/danhsachcosoyte";
    }
}
