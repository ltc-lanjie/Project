package com.zhongxing.test;

import java.sql.SQLException;
import java.text.ParseException;

import com.zhongxing.server.Update;
import com.zhongxing.server.impl.UpdateImpl;


public class Test {
	public static void main(String[] args) throws ParseException, SQLException {
		/*UserDao ud=new UserDaoImpl();
		String[] type=new String[]{ud.UPASSWORD,ud.UTELPHONE,ud.UBIRTHDATE};
		String[] a=new String[]{"123456","13111111111",new Date().toString()};
		ud.update(1, type, a);
		User user=new User("wangwwu",3,"123","13000000000","12.png",new Date(),1,"manager");*/
		/*Connection conn=JDBCUtil.getConnection("signsys", "root", "123456");
		String sql="insert into user values()";
		PreparedStatement pre=conn.prepareStatement(sql);
		System.out.println(pre.getUpdateCount());
		System.out.println(pre.execute());*/
		/*User user =new User();
		ud.insert(user);*/
		/*ud.update(user);*/
		/*List<User> li=ud.select("zhangsan");
		for(User u:li){
			System.out.println(u);
		}*/
		/*new SimpleDateFormat().parse(new Date().toString());*/
		/*UserDao ud=new UserDaoImpl();
		User user=new User();
		user.setUid(8);
		ud.delete(user);*/
		/*Scheduling sc=new Scheduling();
		sc.setUid(1);
		sc.setSid(2);
		SchedulingDao sl=new SchedulingDaoImpl();*/
		/*List<Scheduling> li=sl.selectUid(1);
		for(Scheduling s:li){
			System.out.println(s);
		}*/
		/*sl.update(sc);*/
//		Shift s1=new Shift();
//		s1.setSid(3);
//		s1.setScheckin("02:00:00");
//		s1.setSoffcall("04:00:00");
//		ShiftDaoImpl s=new ShiftDaoImpl();
//		
//		s.delete(s1);
//		List<Shift> li=s.selectAll();
//		for(Shift u:li){
//			System.out.println(u);
//		}
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		Date before = sim.parse("2017-07-10");
//		int id = 112;
//		Date after = sim.parse("2017-07-11");
//		SignDao signDao = new SignDaoImpl();
//		System.out.println(signDao.select(id, before, after,2).size());
//		int year = 2017;
//		int month = 7;
//		System.out.println(signDao.select(id, year, month).size());
		
		Update update = new UpdateImpl();
		int id = 112;
		String password = "123456";
		System.out.println(update.upDateUserPwd(id, password));
	}
}
