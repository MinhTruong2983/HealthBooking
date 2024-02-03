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
	    private String machuyenkhoa;

	  
	    private String anh;

	  
	    private String tenchuyenkhoa;
}
