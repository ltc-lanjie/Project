package com.zhongxing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhongxing.dao.UserDao;
import com.zhongxing.dao.impl.UserDaoImpl;
import com.zhongxing.entity.Sign;
import com.zhongxing.entity.User;
import com.zhongxing.server.ShowAll;
import com.zhongxing.server.ShowPersonal;
import com.zhongxing.server.impl.ShowAllImpl;
import com.zhongxing.server.impl.ShowPersonalImpl;

public class ShowAllServlet extends HttpServlet {

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
		String str_id=request.getParameter("id");
		Integer id=0;
		Integer pageNumber=-1;
		String signType=null;
		
		String name=request.getParameter("name");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String pageNum=request.getParameter("pageNum");
		Integer signstatus=new Integer(request.getParameter("signstatus"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserDao ud=new UserDaoImpl();
		if(name!=""){
			List<User> list1=new ArrayList();
			list1=ud.select(name);
			if(list1.size()>0){
				id=list1.get(0).getUid();
				
			}
		}else if(str_id!=""){
			if(str_id.matches("[0-9]+")){
				id=new Integer(str_id);
			}
		}
		if(pageNum.matches("[1-9][0-9]*")){
			pageNumber=new Integer(pageNum);
		}else out.print("errorPage");
		Date before=null;
		Date after=null;
		try {
			before = sdf.parse(start);
			after = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(id+" "+name+" "+start+" "+end+" "+pageNum+" "+signstatus);
		ShowAll sa=new ShowAllImpl();
		ShowPersonal sp=new ShowPersonalImpl();
		if(before!=null&&after!=null&&(before.getTime()<=after.getTime())){
			List<Sign> list2=new ArrayList();
			if(id==0){
				if(signstatus==6) 
					{
					list2=sa.showTabel(before, after);
					}
				else {
					list2=sa.showTable(request.getParameter("signstatus"), before, after);
				}
			}else
			if(signstatus==6) list2=sp.showTabel(id, before, after);
			else list2=sp.showTable(id, signstatus, before, after);
			int pageStart=(pageNumber-1)*10+1;
			int pageEnd=pageNumber*10;
			if(pageNumber==-1||list2.size()<pageStart) {
				out.print("errorPage");
				/*System.out.println(pageStart+"  "+pageNumber+(pageNumber<1));
				return;*/
			}
			else if(list2.size()>pageEnd){
				for(int i=(pageNumber-1)*10;i<pageNumber*10;i++){
					Sign sign=list2.get(i);
					Integer sign_uid=sign.getUid();
					User user=ud.select(sign_uid).get(0);
					switch(sign.getSignstatus()){
					case 0:signType="正常签到";break;
					case 1:signType="迟到";break;
					case 2:signType="早退";break;
					case 3:signType="请假";break;
					case 4:signType="缺席";break;
					case 5:signType="迟到且早退";break;
					}
					//姓名 编号 上班签到 下班签到 日期 签到情况
					out.print(String.format("<tr><td>%s</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
							user.getUname(),sign.getUid(),sign.getCheckintime(),sign.getOffcalltime(),sign.getSigndate(),signType));
				}
			}else {
				for(int i=(pageNumber-1)*10;i<list2.size();i++){
					Sign sign=list2.get(i);
					Integer sign_uid=sign.getUid();
					User user=ud.select(sign_uid).get(0);
					switch(sign.getSignstatus()){
					case 0:signType="正常签到";break;
					case 1:signType="迟到";break;
					case 2:signType="早退";break;
					case 3:signType="请假";break;
					case 4:signType="缺席";break;
					case 5:signType="迟到且早退";break;
					}
					//姓名 编号 日期 上班签到 下班签到  签到情况
					String outprint=String.format("<tr><td>%s</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
							user.getUname(),sign.getUid(),sdf.format(sign.getSigndate()),sign.getCheckintime(),sign.getOffcalltime(),signType);
					out.print(outprint);
				}
			}
		}
		else {
			out.print("errorTime");
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
