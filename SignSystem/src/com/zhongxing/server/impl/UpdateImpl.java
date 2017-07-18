package com.zhongxing.server.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zhongxing.dao.SchedulingDao;
import com.zhongxing.dao.ShiftDao;
import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.SchedulingDaoImpl;
import com.zhongxing.dao.impl.ShiftDaoImpl;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.Scheduling;
import com.zhongxing.entity.Shift;
import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;
import com.zhongxing.server.Update;

public class UpdateImpl implements Update {
	User user = new User();
	Sign sign = new Sign();
	Shift shift = new Shift();
	Scheduling scheduling = new Scheduling();
	UserDao userDao = new UserDaoImpl();
	SignDao signDao = new SignDaoImpl();
	ShiftDao shiftDao = new ShiftDaoImpl();
	SchedulingDao schedulingDao = new SchedulingDaoImpl();

	@Override
	public boolean insertUser(String uname, String utelphone, String upicture,Date ubirthdate, Integer usex, String utype) {
		user.setUname(uname);
		user.setUpassword("123456");//初始密码
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
		user.setUid(uid);
		user.setUpassword(pwd);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUpassword(pwd);
		return userDao.update(list.get(0));
	}

	@Override
	public boolean upDateUserTel(Integer uid, String utelphone) {
		user.setUid(uid);
		user.setUtelphone(utelphone);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUtelphone(utelphone);
		return userDao.update(list.get(0));
	}

	@Override
	public boolean upDateUserPicture(Integer uid, String upicture) {
		user.setUid(uid);
		user.setUpicture(upicture);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUpicture(upicture);
		return userDao.update(list.get(0));
	}

	@Override
	public boolean upDateUserBirthdate(Integer uid, Date ubirthdate) {
		user.setUid(uid);
		user.setUbirthdate(ubirthdate);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUbirthdate(ubirthdate);
		return userDao.update(list.get(0));
	}

	@Override
	public boolean upDateUserSex(Integer uid, Integer usex) {
		user.setUid(uid);
		user.setUsex(usex);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUsex(usex);
		return userDao.update(list.get(0));
	}

	@Override
	public boolean upDateUserType(Integer uid, String utype) {
		user.setUid(uid);
		user.setUtype(utype);
		List<User> list = userDao.select(uid);
		if (list.size() == 0) {
			return false;
		}
		list.get(0).setUtype(utype);
		return userDao.update(list.get(0));
	}

	@Override
	public String upDateSignCheckintime(Integer uid, String checkintime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sign.setUid(uid);
		List<Sign> list = signDao.select(uid);
		String d2=sdf.format(new Date());
		for(int i=0;i<list.size();i++){
			String d1=sdf.format(list.get(i).getSigndate());
			if(d1.equals(d2)) {
				sign=list.get(i);
				if(sign.getCheckintime()!=null){
					return "error1"; // error1签过了
				}
				sign.setCheckintime(checkintime);
			}else return "error2";                               //error2凌晨插入异常
		}
		if (list.size() == 0) {
			return "error2";                                     //error2签到操作异常
		}
		return signDao.update(sign)?"success":"error2";
	}

	@Override
	public String upDateSignOffcalltime(Integer uid, String offcalltime) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sign.setUid(uid);
		List<Sign> list = signDao.select(uid);
		String d2=sdf.format(new Date());
		for(int i=0;i<list.size();i++){
			String d1=sdf.format(list.get(i).getSigndate());
			if(d1.equals(d2)) {
				sign=list.get(i);
				if(sign.getOffcalltime()!=null){                   //error1已经签离
					return "error1";								//error4凌晨插入异常
				}													//error4签离操作异常
				sign.setOffcalltime(offcalltime);
			}else return "error4";
		}
		if (list.size() == 0) {
			return "error4";
		}
		return signDao.update(sign)?"success":"error4";
	}

	@Override
	public boolean upDateSignSignstatus(Integer uid, int signstatus) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sign.setUid(uid);
		List<Sign> list = signDao.select(uid);
		String d2=sdf.format(new Date());
		for(int i=0;i<list.size();i++){
			String d1=sdf.format(list.get(i).getSigndate());
			if(d1.equals(d2)) {
				sign=list.get(i);
				sign.setSignstatus(signstatus);
			}
		}
		if (list.size() == 0) {
			return false;
		}
		return signDao.update(sign);
	}

	@Override
	public boolean upDateScheduling(int uid, int sid) {
		scheduling.setUid(uid);
		scheduling.setSid(sid);		
		return schedulingDao.update(scheduling);
	}

	@Override
	public boolean upDateShift(Integer sid, String scheckin, String soffcall) {
		shift.setSid(sid);
		shift.setScheckin(scheckin);
		shift.setScheckin(soffcall);		
		return shiftDao.update(shift);
	}

}
