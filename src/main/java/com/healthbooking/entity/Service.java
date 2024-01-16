package com.healthbooking.entity;

import javax.persistence.Column;
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
@Table(name = "services")
public class Service {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "service_id")
	    private int serviceId;

	    @Column(name = "service_name", unique = true)
	    private String serviceName;

	    @Column(name = "img")
	    private String img;

	    @ManyToOne
	    @JoinColumn(name = "package_id")
	    private Package aPackage;

	    @ManyToOne
	    @JoinColumn(name = "specialty_id")
	    private Specialties specialty;

}
