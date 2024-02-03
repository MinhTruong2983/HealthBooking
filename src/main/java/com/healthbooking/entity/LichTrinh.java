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
    private int malichtrinh;

  
    private LocalDate ngaylamviec;

    
    private LocalTime thoigianbatdau;

  
    private LocalTime thoigianketthuc;


    @ManyToOne
    @JoinColumn(name = "mabacsi", insertable = false, updatable = false)
    private BacSi bacsi;


}
