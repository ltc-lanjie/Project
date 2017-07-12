package com.zhongxing.server.impl;

import java.util.List;

import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.User;
import com.zhongxing.server.Login;

public class LoginImpl implements Login {
	User user = new User();
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean checkById(Integer inputId) {
		List<User> list = userDao.select(inputId);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String check(Integer inputId, String inputPassword) {
		List<User> list = userDao.select(inputId);
		for (User user : list) {
			if (user.getUpassword().equals(inputPassword)) {
				
			}
		}
		return null;
	}

}
