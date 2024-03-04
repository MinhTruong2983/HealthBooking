package com.healthbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LichHen")
public class LichHen {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int maLichHen;
    
	    @Column(columnDefinition = "nvarchar(max)")
	    private String TrangThai;
	    
	    @Column(columnDefinition = "nvarchar(max)")
	    private String mieuta;
	    
	    @Column(columnDefinition = "nvarchar(max)")
	    private String thanhtoan;
	    
	    @Column(columnDefinition = "nvarchar(max)")
	    private long giakham;

	    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "maLichTrinh", referencedColumnName = "maLichTrinh")
	    private LichTrinh maLichTrinh;

	    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "maBenhNhan")
	    private BenhNhan maBenhNhan;

}
