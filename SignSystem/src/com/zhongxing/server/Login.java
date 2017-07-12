package com.zhongxing.server;

public interface Login {
	boolean checkById(Integer inputId);
	String check(Integer inputId,String inputPassword);
}
