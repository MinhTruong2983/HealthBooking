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
    private int macosoyte;

    
    private String tencosoyte;

    private String diachi;

    private String thongtin;
    
    private String anh;
  
}
