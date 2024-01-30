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
@Table(name = "schedules")
public class Schedule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

  
    private LocalDate workDate;

    
    private LocalTime startTime;

  
    private LocalTime endTime;


    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private BacSi doctor;


}
