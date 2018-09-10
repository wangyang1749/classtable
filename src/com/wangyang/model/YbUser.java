package com.wangyang.model;

public class YbUser {
	private int yb_userid;
	private String yb_realname;
	private int yb_schoolid;
	private String yb_schoolname;
	private String yb_collegename;
	private String yb_classname;
	private int yb_enteryear;
	private int yb_studentid;
	private int type;
	private int state;
	
	public int getYb_userid() {
		return yb_userid;
	}
	public void setYb_userid(int yb_userid) {
		this.yb_userid = yb_userid;
	}
	public String getYb_realname() {
		return yb_realname;
	}
	public void setYb_realname(String yb_realname) {
		this.yb_realname = yb_realname;
	}
	
	public int getYb_schoolid() {
		return yb_schoolid;
	}
	public void setYb_schoolid(int yb_schoolid) {
		this.yb_schoolid = yb_schoolid;
	}
	public String getYb_schoolname() {
		return yb_schoolname;
	}
	public void setYb_schoolname(String yb_schoolname) {
		this.yb_schoolname = yb_schoolname;
	}
	public String getYb_collegename() {
		return yb_collegename;
	}
	public void setYb_collegename(String yb_collegename) {
		this.yb_collegename = yb_collegename;
	}
	public String getYb_classname() {
		return yb_classname;
	}
	public void setYb_classname(String yb_classname) {
		this.yb_classname = yb_classname;
	}
	public int getYb_enteryear() {
		return yb_enteryear;
	}
	public void setYb_enteryear(int yb_enteryear) {
		this.yb_enteryear = yb_enteryear;
	}
	public int getYb_studentid() {
		return yb_studentid;
	}
	public void setYb_studentid(int yb_studentid) {
		this.yb_studentid = yb_studentid;
	}
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public boolean equals(Object obj) {
		YbUser  yu =(YbUser)obj;
		if(this.yb_userid==yu.yb_userid) {
			return true;
		}
		
		return false;
	}
	@Override
	public String toString() {
		return "YbUser [yb_userid=" + yb_userid + ", yb_realname=" + yb_realname + ", yb_schoolid=" + yb_schoolid
				+ ", yb_schoolname=" + yb_schoolname + ", yb_collegename=" + yb_collegename + ", yb_classname="
				+ yb_classname + ", yb_enteryear=" + yb_enteryear + ", yb_studentid=" + yb_studentid + ", type=" + type
				+ ", state=" + state + "]";
	}
	
	
	
	
}
