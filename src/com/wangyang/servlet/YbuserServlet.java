package com.wangyang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyang.dao.IYbUserDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.Pager;
import com.wangyang.model.YbUser;

/**
 * Servlet implementation class YbuserServlet
 */
@WebServlet("/ybus.admin")
public class YbuserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private IYbUserDao ud = MysqlDaoFactory.getInstance().createYbUserDao();
	public String yulist(HttpServletRequest req,HttpServletResponse resp) {
		String con =req.getParameter("con");
		if(con==null) {
			con="";
		}
		int pageIndex=1;
		if(req.getParameter("pageIndex")!=null) {
			pageIndex=Integer.parseInt(req.getParameter("pageIndex"));
		}
		
		Pager<YbUser> page = ud.find(con, pageIndex, 5);
		req.setAttribute("con", con);
		req.setAttribute("user", page);
		
		return "ybuslist.jsp";
	}
	public void type(HttpServletRequest req,HttpServletResponse resp) {
		 
		PrintWriter out=null; 
		try {
			out = resp.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		YbUser yb = (YbUser)req.getSession().getAttribute("ybuser");
		//如果当前用户是管理员或者是id为12927286的用户，才可以进行=删除
		if(yb.getType()==1||yb.getYb_userid()==12927286) {
			if(req.getParameter("id")==null||req.getParameter("type")==null) {
				return;
			}
			int id,type;
			id = Integer.parseInt(req.getParameter("id"));
			type=Integer.parseInt(req.getParameter("type"));
			if(type==1) {
				out.write("<button onclick=\"setType("+id+",0)\">管理员</button> ");
			}else {
				out.write("<button onclick=\"setType("+id+",1)\">普通用户</button>");
			}
			
			ud.type(id, type);
		}else {
			out.write("你没有权限进行该操作！！！");
		}
		out.close();
		
	}
	public void state(HttpServletRequest req,HttpServletResponse resp) {
		 
		PrintWriter out=null; 
		try {
			out = resp.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//在filter中进行统一处理
		if(req.getParameter("id")==null||req.getParameter("state")==null) {
			return;
		}
		int id,state;
		id = Integer.parseInt(req.getParameter("id"));
		state=Integer.parseInt(req.getParameter("state"));
		if(state==1) {
			out.write("<button onclick=\"setState("+id+",0)\">启用</button> ");
		}else {
			out.write("<button onclick=\"setState("+id+",1)\">禁用</button>");
		}
		
		ud.state(id, state);
		out.close();
	
	}
	
}
