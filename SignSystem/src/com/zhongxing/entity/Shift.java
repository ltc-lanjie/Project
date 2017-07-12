package com.zhongxing.entity;

import java.util.Date;

public class Shift {
	private Integer sid;
	private String scheckin;
	private String soffcall;
	public Shift() {
		super();
	}
	public Shift(Integer sid, String scheckin, String soffcall) {
		super();
		this.sid = sid;
		this.scheckin = scheckin;
		this.soffcall = soffcall;
	}
	@Override
	public String toString() {
		return "Shift [sid=" + sid + ", scheckin=" + scheckin + ", soffcall="
				+ soffcall + "]";
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getScheckin() {
		return scheckin;
	}
	public void setScheckin(String scheckin) {
		this.scheckin = scheckin;
	}
	public String getSoffcall() {
		return soffcall;
	}
	public void setSoffcall(String soffcall) {
		this.soffcall = soffcall;
	}
}
