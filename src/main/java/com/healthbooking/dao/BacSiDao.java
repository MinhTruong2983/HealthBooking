package com.healthbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthbooking.entity.BacSi;

public interface BacSiDao extends JpaRepository<BacSi, Integer>{

	 
	 
	  @Query("SELECT bs FROM BacSi bs WHERE bs.chuyenKhoa.maChuyenKhoa = :maChuyenKhoa")
	    List<BacSi> findByMaChuyenKhoa(@Param("maChuyenKhoa") String maChuyenKhoa);
	
	  
	  @Query("SELECT bs FROM BacSi bs WHERE bs.chuyenKhoa.maChuyenKhoa = :maChuyenKhoa AND bs.khuVuc = :khuVuc")
	  List<BacSi> findByMaChuyenKhoaAndKhuVuc(@Param("maChuyenKhoa") String maChuyenKhoa, @Param("khuVuc") String khuVuc);

	  
	  // Tìm kiếm bác sĩ theo khu vực
	    List<BacSi> findByKhuVuc(String khuVuc);
	    
	    
	    List<BacSi> findByCoSoYTe_MaCoSoYTe(int maCoSoYTe);
	    
	    BacSi findByEmail(String email);
}
