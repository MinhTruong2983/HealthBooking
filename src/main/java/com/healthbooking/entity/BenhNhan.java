package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BenhNhan")
public class BenhNhan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maBenhNhan;


    private String hoVaTen;

    private String diaChi;


    private String email;

    private String soDienThoai;

  
    private String gioiTinh;

    private Integer tuoi;

    private String hinhAnh;
}
