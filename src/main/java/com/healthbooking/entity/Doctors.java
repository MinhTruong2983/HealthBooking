package com.healthbooking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
	@Table(name = "doctors")
	public class Doctors {
	
		     @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		     private int doctorId;

		     private String doctorName;
		     private String email;
		     private String phoneNumber;
		     private String gender;
		     private int age;
		     private String specialtyId;
		     private String img;
		     private String qualification;
		     
		     @ManyToOne
		     @JoinColumn(name = "medical_facility_id")
		     private MedicalFacility medicalFacility;

		     @ManyToOne
		     @JoinColumn(name = "specialty")
		     private Specialties specialty;
		    
		  
		    @OneToMany(mappedBy = "doctor")
		    private List<Schedule> schedule;
	
}
