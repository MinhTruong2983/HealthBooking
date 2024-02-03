package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CoSoYTe")
public class CoSoYTe {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCoSoYTe;

    
    private String tenCoSoYTe;

    private String diaChi;

    private String thongTin;
    
    private String hinhAnh;
  
}
