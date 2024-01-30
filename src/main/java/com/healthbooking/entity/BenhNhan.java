package com.healthbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class BenhNhan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;


    private String fullName;

    private String address;


    private String email;

    private String phoneNumber;

  
    private String gender;

    private Integer age;

    private String img;
}
