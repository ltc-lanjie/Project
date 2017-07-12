package com.zhongxing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUtil {
	public static Connection getConnection(String database,String user,String password){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败");
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn,PreparedStatement pre,ResultSet re){
		try{
			if(re!=null){
				re.close();
			}
			if(pre!=null){
				pre.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
