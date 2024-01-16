package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.MedicalFacility;

public interface MedicalFacilityDao extends JpaRepository<MedicalFacility, Integer>{

}
