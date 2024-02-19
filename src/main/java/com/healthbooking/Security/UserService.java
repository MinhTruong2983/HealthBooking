package com.healthbooking.Security;

import org.springframework.stereotype.Service;


import com.healthbooking.entity.TaiKhoan;

public interface UserService  {

	
	TaiKhoan findByName(String username);
}
