package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.TaiKhoan;

public interface TaiKhoanDao extends JpaRepository<TaiKhoan, String> {

}
