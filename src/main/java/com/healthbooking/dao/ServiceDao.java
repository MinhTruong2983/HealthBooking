package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Service;

public interface ServiceDao extends JpaRepository<Service, Integer>{

}
