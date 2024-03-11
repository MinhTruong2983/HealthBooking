package com.healthbooking.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.BacSi;
import com.healthbooking.entity.LichTrinh;

public interface LichTrinhDao extends JpaRepository<LichTrinh, Integer>{




    List<LichTrinh> findByTrangThai(String trangThai);
    
    
	List<LichTrinh> findByNgayLamViecAndMaBacSi(LocalDate ngayLamViec, BacSi maBacSi);



	List<LichTrinh> findByNgayLamViecAndMaBacSiAndTrangThai(LocalDate ngayLamViec, BacSi doctor, String trangThai);


    List<LichTrinh> findByMaBacSiAndTrangThai
    ( BacSi maBacSi, String trangThai);



	List<LichTrinh> findByMaBacSiAndTrangThaiAndNgayLamViecBetween(BacSi doctor, String trangThai,
			LocalDate currentDate, LocalDate endDate);

	
    
}
