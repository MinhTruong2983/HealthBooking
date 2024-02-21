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
@Table(name = "ChuyenKhoa")
public class ChuyenKhoa {
	
	 
		@Id
		@Column(columnDefinition = "nvarchar(255)")
	    private String maChuyenKhoa;

		@Column(columnDefinition = "nvarchar(max)")
	    private String hinhAnh;

		@Column(columnDefinition = "nvarchar(max)")
	    private String tenChuyenKhoa;
		
		@Column(columnDefinition = "nvarchar(max)")
	    private String mieuTa;
}
