package com.zhongxing.server.impl;

import java.util.ArrayList;
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
import com.zhongxing.server.ShowAll;

public class ShowAllImpl implements ShowAll {
	
	private SignDao signdao=null;
	private UserDao userdao=null;
	private SchedulingDao schedulingdao=null;
	public ShowAllImpl(){
		if(signdao==null){
			signdao=new SignDaoImpl();
		}
		if(userdao==null){
			userdao=new UserDaoImpl();
		}
		if(schedulingdao==null){
			schedulingdao=new SchedulingDaoImpl();
		}
	}
	/**
	 * 通过名字、时间段查询
	 */
	@Override
	public List<Sign> showTabel(String name, Date start, Date end) {
		List<User> li=userdao.select(name);
		
		Integer id=0;
		if(li.size()==1){
			id=li.get(0).getUid();
			
		}
		
		return signdao.select(id,start,end);
	}
	/**
	 * 通过名字、班次、时间段查询
	 */
	@Override
	public List<Sign> showTable(String uname, Integer sid, Date start, Date end) {
		List<Sign> li=showTable(sid,start,end);
		int id=userdao.select(uname).get(0).getUid();
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
					i--;
				}
			}
		}
		return li;
	}
	/**
	 * 通过名字、签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(String name, String type, Date start, Date end) {
		List<Sign> li=this.showTable(type, start, end);
		Integer id=userdao.select(name).get(0).getUid();
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
					i--;
				}
			}
		}
		return li;
	}
	
	/**
	 * 通过名字 、班别、签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(String name, Integer sid, String type,
			Date start, Date end) {
		List<Sign> li=this.showTable(sid,type,start,end);
		int id=userdao.select(name).get(0).getUid();
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
					i--;
				}
			}
		}
		return li;
	}
	/**
	 * 时间段查询
	 */
	@Override
	public List<Sign> showTabel(Date start, Date end) {
		return signdao.selectByDate(start, end);
	}
	/**
	 * 班别、时间段查询
	 */
	@Override
	public List<Sign> showTable(Integer sid, Date start, Date end) {
		List<Scheduling> li1=schedulingdao.selectSid(sid);
		List<Sign> list=new ArrayList();
		if(li1.size()!=0){
			for(Scheduling sc:li1){
				list.addAll(signdao.select(sc.getUid(),start,end));
			}
		}else{
			System.out.println("这次查询没有数据");
		}
		
		return list;
	}
	/**
	 * 签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(String type, Date start, Date end) {
		int status=-1;
		try{
			status=Integer.valueOf(type);
		}catch(Exception ex){
			System.out.println("请输入正确的类型");
			return null;
		}
		List<Sign> li=signdao.selectByDate(start, end);
		for(int i=0;i<li.size();i++){
			if(li.get(i).getSignstatus()!=status){
				li.remove(i);
				i--;
			}
			
		}
		return li;
	}
	/**
	 * //班别、签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(Integer sid, String type, Date start, Date end) {
		int status=-1;
		try{
			status=Integer.valueOf(type);
		}catch(Exception ex){
			System.out.println("请输入正确的类型");
			return null;
		}
		List<Sign> li=this.showTable(sid,start,end);
		for(int i=0;i<li.size();i++){
			if(li.get(i).getSignstatus()!=status){
				li.remove(i);
				i--;
			}
		}
		return li;
	}

}
