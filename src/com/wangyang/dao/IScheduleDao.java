package com.wangyang.dao;

import java.io.PrintWriter;

import com.wangyang.model.Pager;
import com.wangyang.model.Schedule;

import jxl.Cell;

public interface IScheduleDao {
	int[] add(Cell[] cells);
	int findClass(String classname);
	Pager<Schedule> find(String condition,int pagesize,int currentpage);
	void setOut(PrintWriter out) ;
}
