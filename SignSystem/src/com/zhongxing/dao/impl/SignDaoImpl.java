package com.zhongxing.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zhongxing.dao.DBDao;
import com.zhongxing.dao.SignDao;
import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;

public class SignDaoImpl implements SignDao {
	DBDao dbDao = new DBDaoImpl();
	
	@Override
	public List<Sign> selectAll() {
		String sql = "select s.signdate,s.signstatus,u.uname from sign s, user u where s.uid = u.uid";
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}

	@Override
	public boolean update(Sign sign) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String sql = String.format("update sign set checkintime = '%s',offcalltime = '%s',signstatus = '%d' where uid = '%d' and signdate = '%s'", sign.getCheckintime(),sign.getOffcalltime(),sign.getSignstatus(),sign.getUid(),sim.format(sign.getSigndate()));;
		boolean result = dbDao.update(sql);
		return result;
	}

	@Override
	public boolean insert(Sign sign) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String sql = String.format("insert into sign(uid,signdate,signstatus) values('%d','%s',0)", sign.getUid(),sim.format(sign.getSigndate()));
		boolean result = dbDao.insert(sql);
		return result;
	}
	
	@Override
	public List<Sign> select(int id) {
		String sql = "select * from sign where uid = " + id;
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}

	@Override
	public List<Sign> selectByDate(Date before, Date after) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String sql = String.format("select * from sign where signdate between '%s' and '%s'", sim.format(before),sim.format(after));
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}

	@Override
	public List<Sign> selectByStatus(int status) {
		String sql = "select * from sign where signstatus = " + status;
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}
	
	@Override
	public List<Sign> select(int id, Date before, Date after) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String sql = String.format("select * from sign where uid = " + id +" and signdate between '%s' and '%s'", sim.format(before),sim.format(after));
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}
	
	@Override
	public List<Sign> select(int id, Date before, Date after, int status) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String sql = String.format("select * from sign where uid = " + id +" and signdate between '%s' and '%s' and signstatus = '%d'", sim.format(before),sim.format(after),status);
		List<Sign> list = dbDao.select(sql, Sign.class);
		return list;
	}
}
