package com.zhongxing.dao;

import java.util.Date;
import java.util.List;

import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;

public interface SignDao {
	List<Sign> select(int id);
	List<Sign> selectByDate(Date before,Date after);
	List<Sign> select(int id,Date before,Date after);
	List<Sign> select(int id,Date before,Date after,int status);
	public List<Sign> select(int id,int year,int month) ;
	List<Sign> selectAll();
	List<Sign> selectByStatus(int status);
	boolean update(Sign sign);
	boolean insert(Sign sign);
}
