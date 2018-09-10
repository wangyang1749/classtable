package com.wangyang.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyang.model.YbUser;
import com.wangyang.util.AppUtil;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("*.do")
public class UserFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse)response;
		
		YbUser yu =(YbUser) req.getSession().getAttribute("ybuser");
		if(yu==null) {
			resp.sendRedirect(AppUtil.BACKURL);
			return;
		}
		if(yu.getState()==0) {
			req.setAttribute("error", "对不起，您已经被管理员禁用！！！！");
			req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, resp);
			return ;
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
