package com.zhongxing.entity;

public class Scheduling {
	private int uid;
	private int sid;
	public Scheduling() {
		super();
	}
	public Scheduling(int uid, int sid) {
		super();
		this.uid = uid;
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Scheduling [uid=" + uid + ", sid=" + sid + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
