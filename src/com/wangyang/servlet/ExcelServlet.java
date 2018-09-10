package com.wangyang.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyang.dao.ExcelDaoFactory;
import com.wangyang.dao.IExcelDao;
import com.wangyang.dao.IScheduleDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.Pager;
import com.wangyang.model.Schedule;
import com.wangyang.model.YbUser;

import jxl.Cell;

/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/es.do")
public class ExcelServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	private IExcelDao ed = ExcelDaoFactory.createExcelDao();
	private IScheduleDao sd = MysqlDaoFactory.getInstance().createSchedule();
	public String getclass(HttpServletRequest req,HttpServletResponse resp) {
		YbUser yu = (YbUser)req.getSession().getAttribute("ybuser");
		//通过数据库查询确定用户身份
		//TUDO通过上传获取excel文件的路径
		Cell[] cells = ed.read(req.getServletContext().getRealPath("/")+"upload/myclass.xls", sd.findClass(yu.getYb_classname()));
		req.setAttribute("cells", cells);
		return "schedule.jsp";
		
	}
	public String schedule(HttpServletRequest req,HttpServletResponse resp) {
		String con =req.getParameter("con");
		if(con==null) {
			con="";
		}
		int pageIndex=1;
		if(req.getParameter("pageIndex")!=null) {
			pageIndex=Integer.parseInt(req.getParameter("pageIndex"));
		}
		Pager<Schedule> page = sd.find(con,pageIndex,20);
		req.setAttribute("con", con);
		req.setAttribute("schedules", page);
		return "schedulelist.jsp";
	}
	public String getotherclass(HttpServletRequest req,HttpServletResponse resp) {
		
		if(req.getParameter("row")==null) {
			return "error.jsp";
		}
		int row = Integer.parseInt(req.getParameter("row"));
		Cell[] cells = ed.read(req.getServletContext().getRealPath("/")+"upload/myclass.xls", row);
		req.setAttribute("cells", cells);
		return "otherclass.jsp";
	}
    
}
