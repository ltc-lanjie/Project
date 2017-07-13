package com.zhongxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhongxing.entity.User;
import com.zhongxing.server.Login;
import com.zhongxing.server.impl.LoginImpl;

public class LoginServlet extends HttpServlet {

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
		Integer inputId=new Integer(request.getParameter("inputId"));
		String inputPWD=request.getParameter("pwd");
		if(inputId!=null&&inputPWD!=null){
			Login login=new LoginImpl();
			User user=login.checkById(inputId);
			if(user!=null){
				String url=login.check(inputId, inputPWD);
				HttpSession session=request.getSession();
				session.setAttribute("id", inputId);
				response.sendRedirect("./mainPage.jsp");
			}else{
				out.print("<script> alert('id不存在，请重新登录。');location.href='./login.html';</script>");
			}
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
