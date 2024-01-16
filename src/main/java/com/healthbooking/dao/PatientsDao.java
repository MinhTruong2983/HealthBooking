package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Patients;

public interface PatientsDao extends JpaRepository<Patients, Integer>{

}
