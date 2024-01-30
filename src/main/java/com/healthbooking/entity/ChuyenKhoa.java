package com.healthbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "specialties")
public class ChuyenKhoa {
	
	    @Id
	    @Column(name = "specialty_id")
	    private String specialtyId;

	    @Column(name = "img")
	    private String img;

	    @Column(name = "specialty_name", unique = true)
	    private String specialtyName;
}
