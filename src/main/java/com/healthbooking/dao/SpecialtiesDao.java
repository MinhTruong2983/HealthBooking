package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Specialties;

public interface SpecialtiesDao extends JpaRepository<Specialties, String>{

}
