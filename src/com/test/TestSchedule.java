package com.test;

import com.wangyang.dao.IScheduleDao;
import com.wangyang.dao.MysqlDaoFactory;

public class TestSchedule {
	private static IScheduleDao sd = MysqlDaoFactory.getInstance().createSchedule();
	public static void main(String[] args) {
		System.out.println(sd.find("思政",1,2).getList());
	}
}
