package com.wangyang.dao;

import com.wangyang.model.Schedule;

public class MysqlDaoFactory implements IDaoFactory{
	private static IDaoFactory f = new MysqlDaoFactory();
	private MysqlDaoFactory() {	}
	public static IDaoFactory getInstance(){
		return f;
	}
	
	private UserDao ud;
	
	@Override
	public IUserDao createUserDao() {
		if(ud==null){
			ud = new UserDao();
		}
		return ud;
	}
	
	private YbUserDao yu;
	@Override
	public IYbUserDao createYbUserDao() {
		
		if(yu==null) {
			yu = new YbUserDao();
		}
		return yu;
	}
	
	private ScheduleDao sd; 
	@Override
	public IScheduleDao createSchedule() {
		if(sd==null) {
			sd = new ScheduleDao();
		}
		return sd;
	}
}
