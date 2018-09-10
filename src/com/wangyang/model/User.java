package com.wangyang.model;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String nickname;
	private String password;

	
	
	private Date date;
	private int type;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", date=" + date + ", type=" + type + ", status=" + status + "]";
	}
	public User( String username, String nickname, String password, Date date, int type, int status) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.date = date;
		this.type = type;
		this.status = status;
	}
	public User(){}
}
