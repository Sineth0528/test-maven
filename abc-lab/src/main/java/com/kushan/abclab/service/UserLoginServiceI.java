package com.kushan.abclab.service;

import java.sql.SQLException;

import com.kushan.abclab.model.UserLoginModel;

public interface UserLoginServiceI {
	
	 public boolean checkLogin(UserLoginModel UserLoginModel) throws ClassNotFoundException, SQLException;

}
