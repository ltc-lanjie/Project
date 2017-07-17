package com.zhongxing.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.zhongxing.dao.DBDao;
import com.zhongxing.dao.UserDao;
import com.zhongxing.entity.User;
/**
 * 查询用户信息，可以通过id或者名字查询
 * @author ZhongXing
 *
 */
public class UserDaoImpl implements UserDao {
	/**
	 * 查询User表中的所有数据
	 */
	private DBDao db=new DBDaoImpl();
	@Override
	public List<User> selectAll() {
		String sql="select * from user;";
		return db.select(sql,User.class);
	}
	
	
	/**
	 * ·
	 */
	@Override
	public boolean  insert(User user) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			if(user.getUbirthdate()!=null){
				String sql=String.format("insert into user(uname,upassword,utelphone,upicture,ubirthdate,usex,utype) values('%s','%s','%s','%s','%s','%s','%s')", 
					user.getUname()==null?"":user.getUname(),
					user.getUpassword()==null?"":user.getUpassword(),
					user.getUtelphone()==null?"":user.getUtelphone(),
					user.getUpicture()==null?"":user.getUpicture(),
					user.getUbirthdate()==null?"":sd.format(user.getUbirthdate()),
					user.getUsex()==null?"0":String.valueOf(user.getUsex()),
					user.getUtype()==null?"":user.getUtype());
				 return db.insert(sql);
			}else{
			String sql=String.format("insert into user(uname,upassword,utelphone,upicture,usex,utype) values('%s','%s','%s','%s','%s','%s')", 
				user.getUname()==null?"":user.getUname(),
				user.getUpassword()==null?"":user.getUpassword(),
				user.getUtelphone()==null?"":user.getUtelphone(),
				user.getUpicture()==null?"":user.getUpicture(),
				user.getUsex()==null?"0":String.valueOf(user.getUsex()),
				user.getUtype()==null?"":user.getUtype());
				return db.insert(sql);
			}
	}

	@Override
	public boolean delete(User user) {
		if(user.getUname()==null){
			String sql=String.format("delete from user where uid = '%d';",user.getUid());
			
			 return db.delete(sql);
		}else{
			String sql=String.format("delete from user where uname = '%s';",user.getUname());
		
		 return  db.delete(sql);
		}
	}

	@Override
	public List<User> select(String name) {
		String sql=String.format("select * from user where uname='%s';", name);
		return db.select(sql, User.class);
	}
	
	@Override
	public List<User> select(int id) {
		String sql=String.format("select * from user where uid='%d';", id);
		return db.select(sql, User.class);
	}

	@Override
	public boolean update(int id, String[] type, String[] args) {
		StringBuffer sb=new StringBuffer(" where uid = "+id+";");
		 return this.update(sb, type, args);
	}

	@Override
	public boolean update(String name, String[] type, String[] args) {
		StringBuffer sb=new StringBuffer(" where uname = "+name+";");
		return this.update(sb, type, args);
	
	}
	private boolean update(StringBuffer sql,String[] type,String[] args){
	
		if(type.length==0||args.length==0){
			System.out.println("请出入参数");
			return false;
		}
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");	
		
		StringBuffer sb=new StringBuffer("update user set ");
		for(int i=0;i<type.length;i++){
			sb=sb.append(type[i]+" = ");
			if(type[i].equals(UserDao.UBIRTHDATE)){
				try {
					sd.parse(args[i]);
				} catch (ParseException e) {
					System.out.println("时间格式不正确");
					return false;
				}
			}
			sb=sb.append("'"+args[i]+"'");
			if(i!=type.length-1){
				sb=sb.append(",");
			}
			
		}
		sb=sb.append(sql);
		
		return db.update(sb.toString());
	}


	@Override
	public boolean update(User user) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");	
		String sql=String.format("update user set uname = '%s' ,upassword= '%s',utelphone='%s',upicture='%s',ubirthday='%s',usex='%d',utype='%s' where uid='%s'",
				user.getUname(),
				user.getUpassword(),
				user.getUtelphone(),
				user.getUpicture(),
				sd.format(user.getUbirthdate()),
				user.getUsex(),
				user.getUtype(),
				user.getUid());
		return db.update(sql);
	}


	@Override
	public Integer selectMaxId() {
		// TODO Auto-generated method stub
		String sql="select uid from user order by uid desc limit 0,1;";
		return db.select(sql,User.class).get(0).getUid();
	}
	
}
