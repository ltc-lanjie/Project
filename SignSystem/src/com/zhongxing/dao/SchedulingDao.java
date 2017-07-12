package com.zhongxing.dao;

import java.util.List;

import com.zhongxing.entity.Scheduling;

public interface SchedulingDao {
	List<Scheduling> selectUid(int uid);
	List<Scheduling> selectSid(int sid);
	List<Scheduling> selectAll();
	boolean update(Scheduling scheduling);
	boolean delete(Scheduling scheduling);
	boolean insert(Scheduling scheduling);
}
