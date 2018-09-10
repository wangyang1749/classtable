package com.wangyang.dao;

import com.wangyang.model.Pager;
import com.wangyang.model.User;

public interface IUserDao {
	void add(User  user);
	Pager<User> find();
	void delete(int id);
	
	boolean loggin(User user);
}
