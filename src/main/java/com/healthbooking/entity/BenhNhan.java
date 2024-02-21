package com.healthbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BenhNhan")
public class BenhNhan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maBenhNhan;

	@Column(columnDefinition = "nvarchar(max)")
    private String hoVaTen;

	@Column(columnDefinition = "nvarchar(max)")
    private String diaChi;

	@Column(columnDefinition = "nvarchar(max)")
    private String email;

	@Column(columnDefinition = "nvarchar(max)")
    private String soDienThoai;

	@Column(columnDefinition = "nvarchar(max)")
    private String gioiTinh;

    private Integer tuoi;

    @Column(columnDefinition = "nvarchar(max)")
    private String hinhAnh;
}
