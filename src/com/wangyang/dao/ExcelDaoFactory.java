package com.wangyang.dao;

public class ExcelDaoFactory {
	
	private static IExcelDao ed =new ExcelDao();
	public static IExcelDao createExcelDao() {
		return ed;
	}
}
