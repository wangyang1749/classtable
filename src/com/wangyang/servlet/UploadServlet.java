package com.wangyang.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyang.dao.ExcelDaoFactory;
import com.wangyang.dao.IExcelDao;
import com.wangyang.dao.IScheduleDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.util.UploadUtil;

import jxl.Cell;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.admin")
public class UploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private IExcelDao ed = ExcelDaoFactory.createExcelDao();
    private IScheduleDao sd = MysqlDaoFactory.getInstance().createSchedule();
	public String uploadpage(HttpServletRequest req,HttpServletResponse resp) {
		return "uploadpage.jsp";
	}
	
	public String upload(HttpServletRequest req,HttpServletResponse resp) {
		
		String name =UploadUtil.upload(req);
		Cell[] cells = ed.readColumn(name, 0);
		
		int result[] =sd.add(cells);
		req.setAttribute("result", result.length);
		return "rediect:upload.admin?method=uploadpage";
	}

}
