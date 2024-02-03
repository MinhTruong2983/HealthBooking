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
    private int mabenhnhan;


    private String hovaten;

    private String diachi;


    private String email;

    private String sodienthoai;

  
    private String gioitinh;

    private Integer tuoi;

    private String anh;
}
