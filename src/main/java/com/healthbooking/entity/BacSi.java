package com.healthbooking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
	@Table(name = "BacSi")
	public class BacSi {
	
		     @Id
			 @GeneratedValue(strategy = GenerationType.IDENTITY)
		     private int maBacSi;

		     private String tenBacSi;
		     private String email;
		     private String soDienThoai;
		     private String gioiTinh;
		     private int tuoi;
		     private String hinhAnh;

		     
		     @ManyToOne
		     @JoinColumn(name = "macosoyte")
		     private CoSoYTe coSoYTe;

		     @ManyToOne
		     @JoinColumn(name = "machuyenKhoa")
		     private ChuyenKhoa chuyenKhoa;

		    @OneToMany(mappedBy = "maBacSi")
		    private List<LichTrinh> lichTrinh;
	
}
