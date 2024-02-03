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
@Table(name = "LichTrinh")
public class LichTrinh {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLichTrinh;

  
    private LocalDate ngayLamViec;

    
//    private LocalTime thoigianbatdau;
//
//  
//    private LocalTime thoigianketthuc;


    @ManyToOne
    @JoinColumn(name = "maBacSi", insertable = false, updatable = false)
    private BacSi maBacSi;


}
