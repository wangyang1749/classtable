package com.wangyang.util;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	private static final String EXCELNAME="myclass.xls";
	public static String upload(HttpServletRequest req) {
		boolean isMultipart= ServletFileUpload.isMultipartContent(req);
		if(!isMultipart) {
			return "";
		}
		String filepath=req.getServletContext().getRealPath("/")+"upload/";
		File file = new File(filepath);
		if(!file.exists()) {
			file.mkdir();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items= upload.parseRequest(req);
			for(FileItem item: items) {
				System.out.println(filepath+item.getName());
				if(!item.isFormField()) {
					item.write(new File(filepath+EXCELNAME));
					return filepath+EXCELNAME;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
