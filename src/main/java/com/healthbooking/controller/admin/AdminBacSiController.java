package com.healthbooking.controller.admin;

import com.healthbooking.dao.BacSiDao;
import com.healthbooking.entity.BacSi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminBacSiController {

    @Autowired
    private BacSiDao bacSiDao;

    @GetMapping("/HealthBooking/admin/bac-si/danh-sach")
    public String showAll(Model model) {
        return "layout/bac-si/danhsachbacsi";
    }


}
