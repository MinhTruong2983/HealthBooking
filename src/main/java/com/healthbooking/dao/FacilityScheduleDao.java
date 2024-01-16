package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.FacilitySchedule;

public interface FacilityScheduleDao extends JpaRepository<FacilitySchedule, Integer>{

}
