package com.healthbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthbooking.entity.Doctors;

public interface DoctorDao extends JpaRepository<Doctors, Integer>{

	 @Query("SELECT d FROM Doctors d WHERE d.specialty.id = :specialtyId")
	    List<Doctors> findBySpecialtyId(@Param("specialtyId") String specialtyId);
	
//	List<Doctors> findBySpecialty(Integer specialtyId);
}
