package com.zhongxing.server;

import java.util.Date;
import java.util.List;

import com.zhongxing.entity.Sign;

public interface ShowPersonal {
	//通过id、时间段查询
	List<Sign> showTabel(Integer id,Date start,Date end);
	//通过id、班别、时间段查询
	List<Sign> showTable(Integer id,Integer sid,Date start,Date end);
	//通过ID、签到情况、时间段查询
	List<Sign> showTable(Integer id,String type,Date start,Date end);
	//通过ID 、班别、签到情况、时间段查询
	List<Sign> showTable(Integer id,Integer sid,String type,Date start,Date end);
}
