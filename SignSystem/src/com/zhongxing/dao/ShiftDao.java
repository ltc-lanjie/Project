package com.zhongxing.dao;

import java.util.List;

import com.zhongxing.entity.Shift;

public interface ShiftDao {
	List<Shift> select(int id);
	List<Shift> selectAll();
	boolean update(Shift shift);
	boolean insert(Shift shift);
	boolean delete(Shift shift); 
}
