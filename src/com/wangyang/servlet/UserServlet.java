package com.wangyang.servlet;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wangyang.dao.IUserDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.Pager;
import com.wangyang.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/us")
public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
      
	private static IUserDao ud = MysqlDaoFactory.getInstance().createUserDao();
	public String register(HttpServletRequest req ,HttpServletResponse resp){
		return "register.jsp";
	}
	public String add(HttpServletRequest req ,HttpServletResponse resp){
		Map<String,String[]> map= req.getParameterMap();
		Set<String> keys = map.keySet();
		User user = new User();
		for(String key : keys){
			try {
				BeanUtils.copyProperty(user, key, map.get(key));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		user.setType(0);
		user.setStatus(0);
		user.setDate(new Date());
		System.out.println(user);
		ud.add(user);
		return "rediect:us?method=userlist";
	}
	public String userlist(HttpServletRequest req ,HttpServletResponse resp){
		Pager<User> page = ud.find();
		req.setAttribute("user",page.getList());
		return "userlist.jsp";
	}

	public void delete(HttpServletRequest req ,HttpServletResponse resp){
		if(req.getParameter("id")!=null) {
			int id = Integer.parseInt(req.getParameter("id"));
			ud.delete(id);
		}
		System.out.println("delete");
	}

}
