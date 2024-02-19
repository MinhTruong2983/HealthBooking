package com.healthbooking.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.LichTrinh;

public interface LichTrinhDao extends JpaRepository<LichTrinh, Integer>{

	 List<LichTrinh> findByNgayLamViec(LocalDate ngayLamViec);
}
