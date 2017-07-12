package com.zhongxing.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;

public interface DBDao {
   	<T> List<T> select (String sql,Class<T> clazz);
	boolean update(String sql);
	boolean insert(String sql);
	boolean delete(String sql);
}
