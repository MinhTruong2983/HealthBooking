package com.healthbooking.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
		     
		     private String kinhNghiem;
		     
		     private String daoTao;
		    
		     private String khamVaDieuTri;
		     
		     private BigDecimal gia;

		     @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		     @JoinColumn(name = "macosoyte")
		     private CoSoYTe coSoYTe;

		     @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		     @JoinColumn(name = "machuyenKhoa")
		     private ChuyenKhoa chuyenKhoa;

		    @OneToMany(mappedBy = "maBacSi")
		    private List<LichTrinh> lichTrinh;

		    
		    @Override
		    public String toString() {
		        return "BacSi" +
		                "maBacSi=" + maBacSi +  ","+
		                "tenBacSi=" + tenBacSi 
		                // Các thuộc tính khác của BacSi +
		                ;
		    }

		
		    


		    
		    
		    
		    
	
}
