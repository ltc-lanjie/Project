package com.zhongxing.server.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.entity.Sign;
import com.zhongxing.server.ShowOnMonth;

public class ShowOnMonthImpl implements ShowOnMonth {

	@Override
	public List<Sign> showTable(Integer id) {
		List<Sign> list=new ArrayList();
		return list;
	}
}
