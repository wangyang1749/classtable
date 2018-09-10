package com.wangyang.dao;

public interface IDaoFactory {
	IUserDao createUserDao();
	IYbUserDao createYbUserDao();
	IScheduleDao createSchedule();
}
