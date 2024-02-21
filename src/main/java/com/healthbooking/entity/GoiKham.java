package com.healthbooking.entity;

import javax.persistence.Column;
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
    private int maGoiKham;

	@Column(columnDefinition = "nvarchar(max)")
    private String tenGoiKham;
	@Column(columnDefinition = "nvarchar(max)")
    private String moTa;

    private double gia;
    @Column(columnDefinition = "nvarchar(max)")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "maBacSi", insertable = false, updatable = false)
    private BacSi maBacSi;


}
