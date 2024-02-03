package com.healthbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LichHen")
public class LichHen {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int malichhen;

	  
	    private LocalDate ngayhen;

	
	    private LocalTime thoigianbatdau;


	    private LocalTime thoigianketthuc;

	    private String trangthailichhen;

	    private String mieuta;
	    
	    @ManyToOne
	    @JoinColumn(name = "lichtrinh", insertable = false, updatable = false)
	    private LichTrinh lichtrinh;

	    @ManyToOne
	    @JoinColumn(name = "benhnhan", insertable = false, updatable = false)
	    private BenhNhan benhnhan;

}
