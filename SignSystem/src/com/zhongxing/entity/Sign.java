package com.zhongxing.entity;

import java.util.Date;

public class Sign {
	private Integer uid;
	private String checkintime;
	private String offcalltime;
	private Date signdate;
	private int signstatus;
	public int getSignstatus() {
		return signstatus;
	}
	public void setSignstatus(int signstatus) {
		this.signstatus = signstatus;
	}
	public Sign() {
		super();
	}
	
	
	public Sign(Integer uid, String checkintime, String offcalltime,
			Date signdate, int signstatus) {
		super();
		this.uid = uid;
		this.checkintime = checkintime;
		this.offcalltime = offcalltime;
		this.signdate = signdate;
		this.signstatus = signstatus;
	}
	@Override
	public String toString() {
		return "Sign [uid=" + uid + ", checkintime=" + checkintime
				+ ", offcalltime=" + offcalltime + ", signdate=" + signdate
				+ ", signstatus=" + signstatus + "]";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getCheckintime() {
		return checkintime;
	}
	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}
	public String getOffcalltime() {
		return offcalltime;
	}
	public void setOffcalltime(String offcalltime) {
		this.offcalltime = offcalltime;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
}
