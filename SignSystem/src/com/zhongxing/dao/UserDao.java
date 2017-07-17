package com.zhongxing.dao;

import java.sql.Connection;
import java.util.List;

import com.zhongxing.entity.User;
import com.zhongxing.util.JDBCUtil;

public interface UserDao {
	static final String UNAME="uname";
	static final String UID="uid";
	static final String UPASSWORD="upassword";
	static final String UTELPHONE="utelphone";
	static final String UPICTURE="upicture";
	static final String UBIRTHDATE="ubirthdate";
	static final String USEX="usex";
	static final String UTYPE="utype";
	List<User> select(String name);
	List<User> select(int id);
	List<User> selectAll();
	Integer selectMaxId();
	boolean update(int id,String[] type,String[] args);
	boolean update(User user);
	boolean update(String name,String[] type,String[] args);
	boolean insert(User user);
	boolean delete(User user);
}
