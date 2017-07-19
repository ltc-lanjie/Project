package com.zhongxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.User;
import com.zhongxing.server.Update;
import com.zhongxing.server.impl.UpdateImpl;

public class Insert_uServlet extends HttpServlet {
	
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDao ud=new UserDaoImpl();
		Integer maxId = ud.selectMaxId();
		for(int i=1;i<6;i++){
			String uname=new String(request.getParameter("uname"+i).getBytes("iso-8859-1"),"utf-8");
			String utelphone=request.getParameter("utelphone"+i);
			String ubirthdate=request.getParameter("ubirthday"+i);
			String usex=request.getParameter("usex"+i);
			String utype=request.getParameter("utype"+i);
			if(uname!=""&&utelphone!=""&&ubirthdate!=""&&usex!=""&&utype!=""){
				Update update=new UpdateImpl();
				try {
					update.insertUser(uname, utelphone, "./headimg1.jpg", sdf.parse(ubirthdate), new Integer(usex), utype);
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(ud.select(maxId+1).size()>0){
			out.print("<script>alert('已经插入以下员工信息：\\n ");
			for(int i=1;i<6;i++){
				List<User> list=ud.select(maxId+i);
				if(list.size()>0){
					User u=list.get(0);
					out.print(i+"、"+(maxId+i)+u.getUname()+"的员工编号是"+u.getUid()+"。\\n ");
				}
			}
			out.print("请及时更新其信息');location.href='./mainPage.jsp';</script>");
		}else out.print("<script>alert('插入信息有误');location.href='./mainPage.jsp';</script>");
		
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
