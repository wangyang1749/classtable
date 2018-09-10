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
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("*.admin")
public class AdminFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("admin");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse)response;
		
		YbUser yu =(YbUser) req.getSession().getAttribute("ybuser");
		if(yu==null) {
			resp.sendRedirect(AppUtil.BACKURL);
			return;
		}
		if(yu.getType()==1||yu.getYb_userid()==12927286) {
			chain.doFilter(request, response);
		}else {
			req.setAttribute("error", "你没有权限进行该操作！！！！");
			req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, resp);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
