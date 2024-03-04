package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.LichHen;

import java.util.List;

public interface LichHenDao extends JpaRepository<LichHen, Integer>{
    List<LichHen> findByMaBenhNhan_Email(String Email);
}
