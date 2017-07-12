package com.zhongxing.entity;

public enum Sex {
	男,女;
	public static String getSex(int i){
		switch(i){
		case 0:	return Sex.男.name();
		case 1:	return Sex.女.name();
		}
		return null;
	} 
}
