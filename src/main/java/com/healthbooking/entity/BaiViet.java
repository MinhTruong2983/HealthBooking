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
@Table(name = "BaiViet")
public class BaiViet {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maBaiViet;

    @ManyToOne
    @JoinColumn(name = "bacsi", insertable = false, updatable = false)
    private BacSi maBacSi;

    private String tieuDe;

  
    private String noiDung;

  
    private LocalDate ngayTao;

    private String hinhAnh;

}
