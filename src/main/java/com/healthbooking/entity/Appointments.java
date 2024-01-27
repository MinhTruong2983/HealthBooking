package com.healthbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "appointments")
public class Appointments {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int appointmentId;

	  
	    private LocalDate appointmentDate;

	
	    private LocalTime startTime;


	    private LocalTime endTime;

	    private String appointmentStatus;

	    private String description;
	    
	    @ManyToOne
	    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
	    private Schedule schedule;

	    @ManyToOne
	    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
	    private Patients patient;

}
