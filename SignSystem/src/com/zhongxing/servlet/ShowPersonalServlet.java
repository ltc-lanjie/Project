package com.zhongxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhongxing.dao.SignDao;
import com.zhongxing.dao.impl.SignDaoImpl;
import com.zhongxing.entity.Sign;

public class ShowPersonalServlet extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Integer id=new Integer(request.getParameter("id"));
		Integer signstatus=new Integer(request.getParameter("signstatus"));
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date before=null;
		Date after=null;
		try {
			before = sdf.parse(start);
			after = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SignDao sd=new SignDaoImpl();
		List<Sign> list=new ArrayList();
		if(before!=null&&after!=null&&(after.getTime()>=before.getTime())){
			list=sd.select(id, before , after);
			
			// 编号  日期  上班签到  下班签到  签到情况  
			for(int i=0;i<list.size();i++){
				Sign sign=list.get(i);
				String signType="";
				switch(sign.getSignstatus()){
				case 0:signType="正常签到";break;
				case 1:signType="迟到";break;
				case 2:signType="早退";break;
				case 3:signType="请假";break;
				case 4:signType="迟到且早退";break;
				}
				out.print(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
						sign.getUid(),sdf.format(sign.getSigndate()),sign.getCheckintime(),sign.getOffcalltime(),signType));
			}
		}else{
			out.print("<script>alert('输入的日期有误请重新输入');location.href='./mainPage.jsp'</script>");
		}
		
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
