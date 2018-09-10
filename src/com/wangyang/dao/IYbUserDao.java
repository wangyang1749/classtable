package com.wangyang.dao;

import com.wangyang.model.Pager;
import com.wangyang.model.YbUser;

public interface IYbUserDao {
	void add(YbUser user);
	Pager<YbUser> find(String condition,int pagesize,int currentpage);
	YbUser load(int id);
	void type(int id,int type);
	void state(int id,int state);
}
