package com.healthbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "appointments")
public class Appointments {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "appointment_id")
	    private int appointmentId;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private Doctors doctor;

	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patients patient;

	    @Column(name = "appointment_date")
	    private LocalDate appointmentDate;

	    @Column(name = "start_time")
	    private LocalTime startTime;

	    @Column(name = "end_time")
	    private LocalTime endTime;

	    @Column(name = "appointment_status")
	    private String appointmentStatus;

	    @Column(name = "description")
	    private String description;

}
