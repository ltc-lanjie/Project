package com.zhongxing.dao.impl;

import java.util.List;

import com.zhongxing.dao.DBDao;
import com.zhongxing.dao.SchedulingDao;
import com.zhongxing.entity.Scheduling;

public class SchedulingDaoImpl implements SchedulingDao {

	private DBDao db=new DBDaoImpl();

	@Override
	public List<Scheduling> selectAll() {
		String sql="select * from scheduling;";
		return db.select(sql, Scheduling.class);
	}

	@Override
	public boolean update(Scheduling scheduling) {
		String sql=String.format("update scheduling set sid = '%d'  where uid='%d'", scheduling.getSid(),scheduling.getUid());
		return db.update(sql);
	}

	@Override
	public boolean delete(Scheduling scheduling) {
		String sql=String.format("delete from scheduling where uid = '%d' and sid = '%d';",scheduling.getUid(),scheduling.getSid());
		return db.delete(sql);
	}

	@Override
	public boolean insert(Scheduling scheduling) {
		String sql="insert into scheduling(uid,sid) values("+scheduling.getUid()+","+scheduling.getSid()+");";
		return db.insert(sql);
	}

	@Override
	public List<Scheduling> selectUid(int uid) {
		String sql="select * from scheduling where uid= "+uid+";";
		return db.select(sql, Scheduling.class);
	}

	@Override
	public List<Scheduling> selectSid(int sid) {
		String sql="select * from scheduling where sid= "+sid+";";
		return db.select(sql, Scheduling.class);
	}

}
