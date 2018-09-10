package com.test;



import java.util.Date;

import com.wangyang.dao.IUserDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.User;

public class UserDaoTest {
	static IUserDao ud = MysqlDaoFactory.getInstance().createUserDao();
	
	public static void add(){
		User u = new User("王五", "zhangsan", "123456", new Date(),0 , 0);
		u.setId(1);
		ud.add(u);
	}
	public static void find(){
		System.out.println(ud.find().getList());
	}
	public static void delete() {
		ud.delete(5);
	}
	public static void main(String[] args) {
		//add();
		//find();
		delete();
	}
}
