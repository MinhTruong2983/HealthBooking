package com.healthbooking.controller.admin;

import com.healthbooking.dao.BenhNhanDao;
import com.healthbooking.entity.BenhNhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminBenhNhanController {

    @Autowired
    private BenhNhanDao benhNhanDao;

    @GetMapping("/HealthBooking/benh-nhan/create")
    public String createPage(Model model) {
        BenhNhan benhNhan = new BenhNhan();
        model.addAttribute("benhNhan", benhNhan);
        return "layout/benh-nhan/create";
    }

    @PostMapping("/HealthBooking/admin/benh-nhan/create")
    public String create(Model model, @Valid @ModelAttribute BenhNhan benhNhan, BindingResult rs) {
        if (benhNhan.getHinhAnh().isEmpty()) {
            rs.addError(new FieldError("benhNhan", "hinhAnh", "Lỗi tải hình ảnh"));
        }

        if (rs.hasErrors()) {
            return "layout/benh-nhan/create";
        }

        return "redirect:/HealthBooking/danh-sach/benh-nhan";
    }

    @GetMapping("/HealthBooking/admin/benh-nhan/danh-sach")
    public String showAll(Model model) {
        List<BenhNhan> benhNhans = benhNhanDao.findAll(Sort.by(Sort.Direction.ASC, "hoVaTen"));
        model.addAttribute("benhNhans", benhNhans);
        return "layout/benh-nhan/danhsachbenhnhan";
    }
}
