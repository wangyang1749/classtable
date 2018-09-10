package com.wangyang.dao;

import com.wangyang.model.Pager;
import com.wangyang.model.YbUser;

public class YbUserDao extends BaseDao<YbUser> implements IYbUserDao{

	@Override
	public void add(YbUser user) {
		user.setType(0);
		user.setState(0);
		super.add(user, "ybuser","yb_userid","yb_realname","yb_schoolid","yb_schoolname","yb_collegename","yb_classname","yb_enteryear","yb_studentid","type","state");
	}

	@Override
	public Pager<YbUser> find(String condition,int currentpage,int pagesize) {
		String sql="SELECT * FROM ybuser";
		String sql2="select count(*)as count from ybuser ";
		if(condition!=null||!"".equals(condition)) {
			sql+=" WHERE yb_realname like '%"+condition+"%' ";
			sql2+=" WHERE yb_realname like '%"+condition+"%'";
		}
		
		return super.find(YbUser.class, sql,sql2,currentpage,pagesize);
	}
	
	@Override
	public YbUser load(int id) {
		String sql="SELECT * FROM ybuser WHERE yb_userid =?";
		return super.load( new YbUser(), sql,id);
	}
	@Override
	public void type(int id,int type) {
		String sql="UPDATE `slw`.`ybuser` SET `type` = ? WHERE `yb_userid` = ? ";
		super.executeQuery(sql, type,id);
	}
	@Override
	public void state(int id, int state) {
		String sql="UPDATE `slw`.`ybuser` SET `state` = ? WHERE `yb_userid` = ? ";
		super.executeQuery(sql, state,id);
	}
}
