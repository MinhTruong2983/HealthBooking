package com.healthbooking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	
	    @Id
	    private String tenDangNhap;
	    
	    @Column(columnDefinition = "nvarchar(255)")
	    private String matKhau;
	    @Column(columnDefinition = "nvarchar(255)")
	    private String quyen;
	 
	 

}
