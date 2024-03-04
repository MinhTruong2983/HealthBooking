package com.healthbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.healthbooking.enums.GioiTinh;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
@Table(name = "BenhNhan")
public class BenhNhan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maBenhNhan;

	@Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Tên không được bỏ trống")
    private String hoVaTen;

    @Size(min = 5, message = "Địa chỉ của bạn chưa được đầy đủ")
    @Size(max = 100, message = "Ký tự quá mức cho phép")
    @NotEmpty(message = "Địa chỉ không được bỏ trống")
	@Column(columnDefinition = "nvarchar(255)")
    private String diaChi;

    @NotEmpty(message = "Email không được bỏ trống")
	@Column(columnDefinition = "nvarchar(100)")
    private String email;

    @NotEmpty(message = "Số điện thoại không được bỏ trống")
	@Column(columnDefinition = "nvarchar(11)")
    private String soDienThoai;

    @Column(columnDefinition = "nvarchar(3)")
    @Enumerated(EnumType.STRING)
    private GioiTinh gioiTinh;

    @NotEmpty(message = "Tuổi không được bỏ trống")
    private Integer tuoi;

    @NotEmpty(message = "Hình ảnh không được bỏ trống")
    @Column(columnDefinition = "nvarchar(100)")
    private String hinhAnh;
}
