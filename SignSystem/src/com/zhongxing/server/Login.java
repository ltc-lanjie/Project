package com.zhongxing.server;

import com.zhongxing.entity.User;

public interface Login {
	User checkById(Integer inputId);
	String check(Integer inputId,String inputPassword);
}
