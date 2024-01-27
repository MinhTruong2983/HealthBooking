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
@Table(name = "packages")
public class Package {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;


    private String packageName;
    
    private String description;

    private double price;

    private String img;

    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctors doctor;


}
