package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Schedule;

public interface ScheduleDao  extends JpaRepository<Schedule, Integer>{

}
