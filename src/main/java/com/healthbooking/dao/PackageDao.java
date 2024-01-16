package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Package;

public interface PackageDao extends JpaRepository<Package, Integer>{

}
