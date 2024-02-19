package com.healthbooking.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthbooking.dao.TaiKhoanDao;
import com.healthbooking.entity.TaiKhoan;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	TaiKhoanDao dao;
	
	@Override
	public TaiKhoan findByName(String username) {
		return dao.findById(username).get();
	}

}
