package com.zhongxing.server;

import java.util.Date;
import java.util.List;

import com.zhongxing.entity.Sign;

public interface ShowAll {
	//查询所有
	//List<Sign> showAll();
	
		//通过名字、时间段查询
		List<Sign> showTabel(String name,Date start,Date end);
		//通过名字、班别、时间段查询
		List<Sign> showTable(String name,Integer sid,Date start,Date end);
		//通过名字、签到情况、时间段查询
		List<Sign> showTable(String name,String type,Date start,Date end);
		//通过名字 、班别、签到情况、时间段查询
		List<Sign> showTable(String name,Integer sid,String type,Date start,Date end);
		//时间段查询
		List<Sign> showTabel(Date start,Date end);
		//班别、时间段查询
		List<Sign> showTable(Integer sid,Date start,Date end);
		//签到情况、时间段查询
		List<Sign> showTable(String type,Date start,Date end);
		//班别、签到情况、时间段查询
		List<Sign> showTable(Integer sid,String type,Date start,Date end);
		
		
		//通过用户编号、时间段、签到情况查询
		List<Sign> showTable(Integer id,Date start,Date end,String type);
		//通过用户姓名、时间段、签到情况查询
		List<Sign> showTabel(String name,Date start,Date end,String type);
		
}
