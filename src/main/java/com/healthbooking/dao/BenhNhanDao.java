package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.BenhNhan;

public interface BenhNhanDao extends JpaRepository<BenhNhan, Integer>{

	
	   BenhNhan findByEmail(String email);
}
