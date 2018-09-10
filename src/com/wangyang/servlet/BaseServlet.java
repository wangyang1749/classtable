package com.wangyang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("text/html;charset=utf-8");
		 String method = req.getParameter("method");
		 String rediect="rediect:";
		 try {
			Method m =this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			String name = (String)m.invoke(this,req,resp );
			if(name==null) {
				return;
			}
			if(name.startsWith(rediect)){
				resp.sendRedirect(name.substring(rediect.length()));
			}else{
				req.getRequestDispatcher("WEB-INF/"+name).forward(req, resp);
			}
		 } catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
