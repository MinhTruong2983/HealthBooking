package com.healthbooking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "posts")
public class Post {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private BacSi doctor;

    private String title;

  
    private String content;

  
    private LocalDate postDate;

    private String img;

}
