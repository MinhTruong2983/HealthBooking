package com.healthbooking.controller;

import com.healthbooking.dao.*;
import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.BenhNhan;
import com.healthbooking.entity.ChuyenKhoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ThongKeController {

    @Autowired
    private BacSiDao doctorDao;

    @Autowired
    private BenhNhanDao benhNhanDao;
    @Autowired
    private CoSoYTeDao coSoYTeDao;
    @Autowired
    private LichHenDao lichHenDao;
    @Autowired
    private ChuyenKhoaDao chuyenKhoaDao;

    @RequestMapping("/HealthBooking/thong-ke")
    public String thongKeHome() {
        return "layout/thong-ke/home";
    }

    @GetMapping("/HealthBooking/thong-ke/bac-si")
    public String BacSi(Model model) {
        List<BacSi> bacSi = doctorDao.findAll();
        model.addAttribute("bacSi", bacSi);
        return "layout/thong-ke/bacSi";
    }
    @GetMapping("/HealthBooking/thong-ke/benh-nhan")
    public String getAllBenhNhan() {
        return "layout/thong-ke/benhNhan";
    }
    @GetMapping("/HealthBooking/thong-ke/doanh-thu")
    public String getAllDoanhThu() {
        return "layout/thong-ke/doanhThu";
    }
    @GetMapping("/HealthBooking/thong-ke/co-so-y-te")
    public String getAllCoSo() {
        return "layout/thong-ke/coSoYTe";
    }
    @GetMapping("/HealthBooking/thong-ke/lich-hen")
    public String getAllLichHen() {
        return "layout/thong-ke/lichHen";
    }
    @GetMapping("/HealthBooking/thong-ke/chuyen-khoa")
    public String getAllChuyenKhoa() {
        return "layout/thong-ke/chuyenKhoa";
    }

}

