package com.healthbooking.entity;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
@Entity
@Table(name = "facilityschedules")
public class FacilitySchedule {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "facilityschedules_id")
	    private int facilitySchedules_id;

	    @ManyToOne
	    @JoinColumn(name = "medical_facility_id")
	    @JsonBackReference
	    private MedicalFacility medicalFacility;

	    @Column(name = "day_of_week")
	    private LocalDate dayOfWeek;

	    @Column(name = "start_time")
	    private Time startTime;

	    @Column(name = "end_time")
	    private Time endTime;

}
