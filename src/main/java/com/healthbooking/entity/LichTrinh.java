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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "LichTrinh")
	public class LichTrinh {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int maLichTrinh;
	
		
	    private LocalDate ngayLamViec;
	
		
	    private LocalTime thoigianbatdau;
	
	    private LocalTime thoigianketthuc;
	
	    @Column(columnDefinition = "nvarchar(max)")
	    private String trangThai;
	
	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name = "maBacSi", referencedColumnName = "maBacSi", insertable = false, updatable = false)
	    private BacSi maBacSi;
	
	    
    

}
