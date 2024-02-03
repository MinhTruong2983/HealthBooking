package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DichVu")
public class DichVu {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int maDichVu;

	    private String tenDichVu;
	    private String hinhAnh;
	    private String loaiDichVu;

}
