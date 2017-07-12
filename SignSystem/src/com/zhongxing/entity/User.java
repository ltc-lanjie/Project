package com.zhongxing.entity;

import java.util.Date;

public class User {
	@Override
	public String toString() {
		return "User [uname=" + uname + ", uid=" + uid + ", upassword="
				+ upassword + ", utelphone=" + utelphone + ", upicture="
				+ upicture + ", ubirthdate=" + ubirthdate + ", usex=" + usex
				+ ", utype=" + utype +  "]";
	}
	private String uname;
	public User() {
		super();
	}
	public User(String uname, Integer uid, String upassword, String utelphone,
			String upicture, Date ubirthdate, Integer usex, String utype
			) {
		super();
		this.uname = uname;
		this.uid = uid;
		this.upassword = upassword;
		this.utelphone = utelphone;
		this.upicture = upicture;
		this.ubirthdate = ubirthdate;
		this.usex = usex;
		this.utype = utype;
	
	}
	private Integer uid;
	private String upassword;
	private String utelphone;
	private String upicture;
	private Date ubirthdate;
	private Integer usex;
	private String utype;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUid() {
		return uid;
	}
	public String getSex(){
		return Sex.getSex(this.usex);
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUtelphone() {
		return utelphone;
	}
	public void setUtelphone(String utelphone) {
		this.utelphone = utelphone;
	}
	public String getUpicture() {
		return upicture;
	}
	public void setUpicture(String upicture) {
		this.upicture = upicture;
	}
	public Date getUbirthdate() {
		return ubirthdate;
	}
	public void setUbirthdate(Date ubirthdate) {
		this.ubirthdate = ubirthdate;
	}
	public Integer getUsex() {
		return usex;
	}
	public void setUsex(Integer usex) {
		this.usex = usex;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}

}
