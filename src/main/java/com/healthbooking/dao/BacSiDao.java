package com.healthbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthbooking.entity.BacSi;

public interface BacSiDao extends JpaRepository<BacSi, Integer>{

	 @Query("SELECT d FROM BacSi d WHERE d.specialty.id = :specialtyId")
	    List<BacSi> findBySpecialtyId(@Param("specialtyId") String specialtyId);
	
//	List<Doctors> findBySpecialty(Integer specialtyId);
}
