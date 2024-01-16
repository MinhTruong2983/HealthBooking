package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Appointments;

public interface AppointmentsDao extends JpaRepository<Appointments, Integer>{

}
