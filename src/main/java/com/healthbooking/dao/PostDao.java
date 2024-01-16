package com.healthbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthbooking.entity.Post;

public interface PostDao extends JpaRepository<Post, Integer>{

}
