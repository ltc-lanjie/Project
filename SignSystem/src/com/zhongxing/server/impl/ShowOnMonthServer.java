package com.zhongxing.server.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.entity.Sign;
import com.zhongxing.server.ShowOnMonth;

public class ShowOnMonthServer implements ShowOnMonth {
	SignDao signDao = new SignDaoImpl();

	@Override
	public List<Sign> showTable(Integer id) {
		List<Sign> list = null;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		return signDao.select(id, year, month);
	}
}
