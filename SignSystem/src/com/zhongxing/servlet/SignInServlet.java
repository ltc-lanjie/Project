package com.zhongxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhongxing.dao.ShiftDao;
import com.zhongxing.dao.impl.ShiftDaoImpl;
import com.zhongxing.entity.Shift;
import com.zhongxing.server.Update;
import com.zhongxing.server.impl.UpdateImpl;

public class SignInServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("id").matches("[0-9]+")){
			Integer id=new Integer(request.getParameter("id"));
			ShiftDao sd=new ShiftDaoImpl();
			SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
			Shift shift=sd.selectAll().get(0);
			try {
				Date d1=sdf1.parse(shift.getScheckin());
				Date d2=sdf1.parse(shift.getSoffcall());
				Date d3=sdf1.parse(sdf1.format(new Date()));
				int signstatus=0;
				if(d3.getTime()<=d1.getTime()) signstatus=0;//正常
				if(d3.getTime()>d1.getTime()&&d3.getTime()<d2.getTime()) signstatus=1;//迟到
				Update update=new UpdateImpl();
				String check_update_sign=update.upDateSignCheckintime(id, sdf1.format(new Date()));
				if(check_update_sign.equals("success")){
					update.upDateSignSignstatus(id, signstatus);
					out.print("签到成功！");
				}
				if(check_update_sign.equals("error1"))
					out.print("今日已经签到，请勿重复签到！");
				if(check_update_sign.equals("error2"))
					out.print("签到异常，请联系管理员。\n 异常码：error2。");
			} catch (ParseException e) {
				out.print("签到失败，请联系管理员！");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else out.print("errorId");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
