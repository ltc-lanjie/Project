package com.zhongxing.dao.impl;

import java.util.List;

import com.zhongxing.dao.DBDao;
import com.zhongxing.dao.ShiftDao;
import com.zhongxing.entity.Shift;

public class ShiftDaoImpl implements ShiftDao {
	private DBDao db=new DBDaoImpl();
	@Override
	public List<Shift> select(int id) {
		String sql="select * from shift where sid = "+id;
		return db.select(sql, Shift.class);
	}

	@Override
	public List<Shift> selectAll() {
		String sql="select * from shift ;";
		return db.select(sql, Shift.class);
	}

	@Override
	public boolean update(Shift shift) {
		String sql=String.format("update shift set scheckin = '%s',soffcall = '%s'  where sid='%d'", shift.getScheckin(),shift.getSoffcall(),shift.getSid());
		return db.update(sql);
	}

	@Override
	public boolean insert(Shift shift) {
		String sql=String.format("insert into shift(sid,scheckin,soffcall) values('%d','%s','%s')",shift.getSid(),shift.getScheckin(),shift.getSoffcall());
		return db.insert(sql);
	}

	@Override
	public boolean delete(Shift shift) {
		String sql=String.format("delete from shift where  sid = '%d';",shift.getSid());
		return db.delete(sql);
	}

}
