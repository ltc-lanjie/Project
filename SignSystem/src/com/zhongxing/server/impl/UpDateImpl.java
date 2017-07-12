package com.zhongxing.server.impl;

import java.util.Date;
import java.util.List;

import com.zhongxing.dao.SchedulingDao;
import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.SchedulingDaoImpl;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.Scheduling;
import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;
import com.zhongxing.server.UpDate;

public class UpDateImpl implements UpDate {
	User user = new User();
	Sign sign = new Sign();
	Scheduling scheduling = new Scheduling();
	UserDao userDao = new UserDaoImpl();
	SignDao signDao = new SignDaoImpl();
	SchedulingDao schedulingDao = new SchedulingDaoImpl();

	@Override
	public boolean insertUser(Integer uid, String utelphone, String upicture,Date ubirthdate, Integer usex, String utype) {
		user.setUid(uid);
		user.setUtelphone(utelphone);
		user.setUpicture(upicture);
		user.setUbirthdate(ubirthdate);
		user.setUsex(usex);
		user.setUtype(utype);
		return userDao.insert(user);
	}

	@Override
	public boolean insertSign(Integer uid, Date signdate) {
		sign.setUid(uid);
		sign.setSigndate(signdate);
		return signDao.insert(sign);
	}

	@Override
	public boolean insertScheduling(int uid, int sid) {
		scheduling.setSid(sid);
		scheduling.setUid(uid);
		return schedulingDao.insert(scheduling);
	}

	@Override
	public boolean upDateUserPwd(Integer uid, String pwd) {
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		System.out.println(list.get(0));
		return true;
//		user.setUid(uid);
//		user.setUpassword(pwd);
//		return userDao.update(user);
	}

	@Override
	public boolean upDateUserTel(Integer uid, String utelphone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateUserPicture(Integer uid, String upicture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateUserBirthdate(Integer uid, Date ubirthdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateUserSex(Integer uid, Integer usex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateUserType(Integer uid, String utype) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateSignCheckintime(Integer uid, String checkintime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateSignOffcalltime(Integer uid, String offcalltime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateSignSignstatus(Integer uid, int signstatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateScheduling(int uid, int sid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateShift(Integer sid, String scheckin, String soffcall) {
		// TODO Auto-generated method stub
		return false;
	}

}
