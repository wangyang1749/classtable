package com.test;

import com.wangyang.dao.IYbUserDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.YbUser;

public class TextYbuser {

	static IYbUserDao ud = MysqlDaoFactory.getInstance().createYbUserDao();
	public static void main(String[] args) {
		System.out.println(ud.find("王5", 1, 2).getList());
	}
}
