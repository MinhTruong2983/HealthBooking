package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GoiKham")
public class GoiKham {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int magoikham;


    private String tengoikham;
    
    private String mieuta;

    private double gia;

    private String anh;

    @ManyToOne
    @JoinColumn(name = "bacsi", insertable = false, updatable = false)
    private BacSi bacsi;


}
