package com.zhongxing.server.impl;

import java.util.Date;
import java.util.List;

import com.zhongxing.dao.SchedulingDao;
import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.SchedulingDaoImpl;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.Sign;
import com.zhongxing.server.ShowPersonal;

public class ShowPersonalImpl implements ShowPersonal {
	private SignDao signdao=null;
	private UserDao userdao=null;
	private SchedulingDao schedulingdao=null;
	public ShowPersonalImpl(){
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
	//通过id、时间段查询
	@Override
	public List<Sign> showTabel(Integer id, Date start, Date end) {
		
		return signdao.select(id, start, end);
	}
	//通过id、班别、时间段查询
	@Override
	public List<Sign> showTable(Integer id, Integer sid, Date start, Date end) {
		List<Sign> li=new ShowAllImpl().showTable(sid, start, end);
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
				}
			}
		}
		return li;
	}
	/**
	 * 通过ID、签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(Integer id, String type, Date start, Date end) {
		List<Sign> li=new ShowAllImpl().showTable(type, start, end);
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
				}
			}
		}
		return li;
	}
	/**
	 * 通过ID 、班别、签到情况、时间段查询
	 */
	@Override
	public List<Sign> showTable(Integer id, Integer sid, String type,
			Date start, Date end) {
		List<Sign> li=new ShowAllImpl().showTable(sid, type, start, end);
		if(li.size()!=0){
			for(int i=0;i<li.size();i++){
				if(li.get(i).getUid()!=id){
					li.remove(i);
				}
			}
		}
		return li;
	}

}
