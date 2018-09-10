package com.wangyang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowUtil {
	
	private static String f="yy-MM-dd HH:ss";
	public static String getDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat(f);
		return format.format(date);
		
	}
}
