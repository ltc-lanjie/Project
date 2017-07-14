package com.zhongxing.dao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhongxing.dao.DBDao;
import com.zhongxing.util.JDBCUtil;

public class DBDaoImpl implements DBDao {
	PreparedStatement pre=null;
	/** 
	 * 一个辅助方法，其他查询都是通过它进行
	 */
	
	@Override
	public <T> List<T> select(String sql, Class<T> clazz) {
		Connection conn=JDBCUtil.getConnection("signsys", "root", "123");
		List<T> li=new ArrayList<T>();
		ResultSet re=null;
		try {
			pre=conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("获取PreparedStatement失败");
			e.printStackTrace();
		}
		try {
			re=pre.executeQuery();
			while(re.next()){
				T t=clazz.newInstance();
				for(int i=0;i<re.getMetaData().getColumnCount();i++){
					StringBuffer set=new StringBuffer("set"+re.getMetaData().getColumnName(i+1));
					set.setCharAt(3,Character.toTitleCase(set.charAt(3)));
					String get="g"+set.substring(1);
					Method getMethod=clazz.getMethod(get,new Class[]{});
					Method setMethod=clazz.getMethod(set.toString(),new Class[]{getMethod.getReturnType()});
					Class clazz1=Class.forName(re.getMetaData().getColumnClassName(i+1));
					Constructor con=null;
					if(re.getString(i+1)==null){
						continue;
					}
					if(clazz1.toString().equals("class java.sql.Date")){
						con=java.util.Date.class.getConstructor(new Class[]{String.class});
						Date date=new SimpleDateFormat("yyyy-MM-dd").parse(re.getString(i+1));
						 setMethod.invoke(t, date);
					}else if(clazz1.toString().equals("class java.sql.Timestamp")){
						con=java.util.Date.class.getConstructor(new Class[]{String.class});
						Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(re.getString(i+1));
						 setMethod.invoke(t, date);
					}else if(clazz1.toString().equals("class java.sql.Time")){
						 setMethod.invoke(t, re.getString(i+1));
					}
					else{
						con=clazz1.getConstructor(new Class[]{String.class});
						setMethod.invoke(t, con.newInstance(re.getString(i+1)));
					}
				}
				li.add(t);
			}
		} catch (SQLException e) {
			System.out.println("加载ResultSet失败");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("创建对象失败");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("创建反射对象失败或使用调用方法出错");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("无法找到特定方法");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("没有权限");
			e.printStackTrace();
		} catch (IllegalArgumentException e1) {
			System.out.println("参数传递失败");
			e1.printStackTrace();
		} catch (ParseException e1) {
			System.out.println("解析时间格式错误");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			System.out.println("启动方法出错");
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("加载类对象失败");
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pre, re);
		}
		
		return li;
	}
	@Override
	public boolean update(String sql) {
		Connection conn=JDBCUtil.getConnection("signsys", "root", "123");
		boolean result = false;
		try {
			pre = conn.prepareStatement(sql);
			pre.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean insert(String sql) {
		Connection conn=JDBCUtil.getConnection("signsys", "root", "123");
		boolean result = false;
		try {
			pre = conn.prepareStatement(sql);
			pre.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean delete(String sql) {
		Connection conn=JDBCUtil.getConnection("signsys", "root", "123");
		boolean result = false;
		try {
			pre = conn.prepareStatement(sql);
			pre.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean db(Connection conn,String sql){
		
		PreparedStatement pre=null;
		boolean flag=false;
		try {
			pre=conn.prepareStatement(sql);
			pre.execute();
			flag=true;
		} catch (SQLException e) {
			System.out.println("加载preparedstatement失败");
			flag=false;
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pre, null);
		}
		return flag;
	}

	
	}
