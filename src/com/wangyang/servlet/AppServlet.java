package com.wangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangyang.dao.IYbUserDao;
import com.wangyang.dao.MysqlDaoFactory;
import com.wangyang.model.YbUser;
import com.wangyang.util.AppUtil;

import cn.yiban.open.FrameUtil;
import cn.yiban.util.HTTPSimple;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/app")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  IYbUserDao ud = MysqlDaoFactory.getInstance().createYbUserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FrameUtil  util = new FrameUtil(req, resp, AppUtil.APPID, AppUtil.SECRET, AppUtil.BACKURL);
		try {
			boolean result = util.perform();
			String token=util.getAccessToken();
			//TUDO此处需要校级权限
			String jsonResult = HTTPSimple.GET("https://openapi.yiban.cn/user/verify_me?access_token=283141c1bd2179bb0cb701690f8b6f3cff1e6e1e");
			//String r = HTTPSimple.GET("https://openapi.yiban.cn/user/verify_me?access_token="+token);
			if(result) {
				//如果是新用户
				YbUser yu = ud.load(Integer.parseInt(util.getUserId()));
				if(yu.equals(new YbUser())) {
					System.out.println("新用户");
					JSONObject jsonObject = JSONObject.fromObject(jsonResult).getJSONObject("info");
					YbUser user = (YbUser)JSONObject.toBean(jsonObject,YbUser.class);
					ud.add(user);
					req.getSession().setAttribute("ybuser", user);
				//否则直接进入
				}else {
					System.out.println("老用户");
					req.getSession().setAttribute("ybuser", yu);
				}
				resp.sendRedirect("es.do?method=getclass");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
