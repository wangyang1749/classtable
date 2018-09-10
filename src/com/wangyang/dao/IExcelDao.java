package com.wangyang.dao;

import jxl.Cell;

public interface IExcelDao {
	
	Cell[] read(String fileName,int row);
	Cell[] readColumn(String fileName,int col);
}
