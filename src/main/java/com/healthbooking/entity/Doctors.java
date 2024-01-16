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

import lombok.Data;

@Data
@Entity
	@Table(name = "doctors")
	public class Doctors {
	
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "doctor_id")
		    private int doctorId;
		 
	
		    @Column(name = "doctor_name")
		    private String doctorName;
	
		    @Column(name = "email")
		    private String email;
	
		    @Column(name = "phone_number")
		    private String phoneNumber;
	
		    @Column(name = "gender")
		    private String gender;
	
		    @Column(name = "age")
		    private int age;
	
		    @Column(name = "img")
		    private String img;
	
		    @Column(name = "qualification")
		    private String qualification;

		    @ManyToOne
		    @JoinColumn(name = "specialty_id")
		    private Specialties specialty;
		
		    @OneToMany(mappedBy = "doctor")
		    private List<Schedule> schedule;
	
}
