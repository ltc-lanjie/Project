package com.zhongxing.server.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zhongxing.entity.Sign;
import com.zhongxing.server.ShowOnMonth;

public class ShowOnMonthServer implements ShowOnMonth {
	

	@Override
	public List<Sign> showTable(Integer id, Date date) {
		List<Sign> list = null;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String str = sim.format(date);
		
		
		return null;
	}

}
