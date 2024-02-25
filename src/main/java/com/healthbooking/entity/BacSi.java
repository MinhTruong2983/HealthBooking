package com.healthbooking.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
		     
		     @Column(columnDefinition = "nvarchar(max)")
		     private String tenBacSi;
		   
		     @Column(columnDefinition = "nvarchar(max)")
			 private String email;
		     @Column(columnDefinition = "nvarchar(max)")
		     private String soDienThoai;
		     @Column(columnDefinition = "nvarchar(max)")
		     private String gioiTinh;
		     private int tuoi;
		     
		     @Column(columnDefinition = "nvarchar(max)")
		     private String hinhAnh;
		     
		     @Column(columnDefinition = "nvarchar(max)")
		     private String kinhNghiem;
		     @Column(columnDefinition = "nvarchar(max)")
		     private String daoTao;
		     @Column(columnDefinition = "nvarchar(max)")
		     private String khamVaDieuTri;
		     
		     private BigDecimal gia;
		     
		     @Column(columnDefinition = "nvarchar(max)")
		     private String khuVuc;

		     @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		     @JoinColumn(name = "macosoyte")
		     private CoSoYTe coSoYTe;

		     @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		     @JoinColumn(name = "machuyenKhoa")
		     private ChuyenKhoa chuyenKhoa;

		     @OneToMany(mappedBy = "maBacSi", cascade = CascadeType.ALL)
		    private List<LichTrinh> LichTrinh;

		    
		    @Override
		    public String toString() {
		        return "BacSi" +
		                "maBacSi=" + maBacSi +  ","+
		                "tenBacSi=" + tenBacSi 
		                // Các thuộc tính khác của BacSi +
		                ;
		    }

		
		    


		    
		    
		    
		    
	
}
