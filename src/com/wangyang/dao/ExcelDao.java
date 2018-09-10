package com.wangyang.dao;

import java.io.File;
import java.io.IOException;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDao implements IExcelDao {
	
	@Override
	public Cell[] read(String fileName,int row) {
		File file = new File(fileName);
		Cell cell[]=null;
		try {
			Workbook workbokk = Workbook.getWorkbook(file);
			Sheet sheet = workbokk.getSheets()[0];
			cell =sheet.getRow(row);
			workbokk.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cell;
	}
	
	@Override
	public Cell[] readColumn(String fileName,int col) {
		File file = new File(fileName);
		Cell cell[]=null;
		try {
			Workbook workbokk = Workbook.getWorkbook(file);
			Sheet sheet = workbokk.getSheets()[0];
			cell =sheet.getColumn(col);
			workbokk.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cell;
	}
	
}
