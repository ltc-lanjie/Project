package com.zhongxing.server;

import java.util.Date;

public interface Update {
	boolean insertUser(String uname,String utelphone,String upicture,Date ubirthdate,Integer usex,String utype);
	boolean insertSign(Integer uid,Date signdate);
	boolean insertScheduling(int uid,int sid);
	
	boolean upDateUserPwd(Integer uid,String pwd);
	boolean upDateUserTel(Integer uid,String utelphone);
	boolean upDateUserPicture(Integer uid,String upicture);
	boolean upDateUserBirthdate(Integer uid,Date ubirthdate);
	boolean upDateUserSex(Integer uid,Integer usex);
	boolean upDateUserType(Integer uid,String utype);
	
	String upDateSignCheckintime(Integer uid,String checkintime);
	String upDateSignOffcalltime(Integer uid,String offcalltime);
	boolean upDateSignSignstatus(Integer uid,int signstatus);
	
	boolean upDateScheduling(int uid,int sid);
	
	boolean upDateShift(Integer sid,String scheckin,String soffcall);
}
