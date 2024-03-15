package com.kushan.abclab.service;

import java.sql.SQLException;

import com.kushan.abclab.dao.UserLoginDao;
import com.kushan.abclab.model.UserLoginModel;

public class UserLoginSer implements UserLoginServiceI {
	
private static UserLoginSer UserLoginSerobj;
	
	public UserLoginSer() {
	}
	
	public static synchronized UserLoginSer getProductServiceInstance() {
		
		if(UserLoginSerobj == null) {
			UserLoginSerobj = new UserLoginSer();
		}
		
		return UserLoginSerobj;
	}
	
	private UserLoginDao userLoginCheck() {
		return new UserLoginDao();
	}

	@Override
	public boolean checkLogin(UserLoginModel UserLoginModel) throws ClassNotFoundException, SQLException {
		return userLoginCheck().CheckUserLogin(UserLoginModel);
	}

}
