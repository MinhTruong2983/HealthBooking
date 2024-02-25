package com.healthbooking.entity;

import javax.persistence.Column;
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

	@Column(columnDefinition = "nvarchar(max)")
    private String tenCoSoYTe;
	@Column(columnDefinition = "nvarchar(max)")
    private String diaChi;
	@Column(columnDefinition = "nvarchar(max)")
    private String thongTin;
	@Column(columnDefinition = "nvarchar(max)")
    private String baoHiem;
    
    private String hinhAnh;
    
    private String hinhAnhNen;
  
}
