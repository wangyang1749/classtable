package com.wangyang.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wangyang.model.Pager;
import com.wangyang.mysql.CreateConnection;

public class BaseDao<T> {
	//拼接插入的sql语句
	private  String sqlString(String... param) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException{
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		boolean flag=true;
		sb2.append(") VALUES (");
		sb.append("INSERT INTO "+param[0]);
		sb.append("(");
		for(int i=1;i<param.length;i++){
			if(flag){
				sb.append(param[i]);
				sb2.append("?");
				flag=false;
			}else{
				sb.append(","+param[i]);
				sb2.append(",?");
			}
		}
		sb2.append(")");
		sb.append(sb2);
		return sb.toString();
		
	}
	//添加到数据库
	public void add(T t,String... param){
		Connection con =null;
		PreparedStatement ps =null;
		
		try {
			String sql =this.sqlString(param);
			System.out.println(sql);
			con = CreateConnection.getConnection();
			ps=con.prepareStatement(sql);
			for(int i=1;i<param.length;i++){
				Method m = t.getClass().getMethod("get"+param[i].substring(0,1).toUpperCase()+param[i].substring(1));
				String type=m.getReturnType().getName();
				//System.out.println(type);
				Object obj = m.invoke(t);
				if(type=="int"){
					ps.setInt(i, (int)obj);
				}else if(type=="java.lang.String"){
					ps.setString(i, (String)obj);
				}else if(type.equals("java.util.Date")){
					ps.setTimestamp(i, new Timestamp(((Date)obj).getTime()));
				}
			}
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.closePreparedStatement(ps);
			CreateConnection.closeConnection(con);
		}
				
	}
	//利用反射读取对象
	private void getObject(T t,ResultSet rs) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Method[] m =t.getClass().getDeclaredMethods();
		for(int i=0;i<m.length;i++){
			String name = m[i].getName();
			if(name.startsWith("set")){
				String type = m[i].getParameterTypes()[0].getName();
				//System.out.println(type);
				//System.out.println(start+name.substring(3));
				try {
					if(type.equals("int")){
						m[i].invoke(t, rs.getInt(name.substring(3)));
					}else if(type.equals("java.lang.String")){
						m[i].invoke(t, rs.getString(name.substring(3)));
					}else if(type.equals("java.util.Date")){
						m[i].invoke(t,rs.getTimestamp(name.substring(3)));
					}
				} catch (SQLException e) {
					continue;
					//e.printStackTrace();
				}
				
			}
		}
	}
	
	public Pager<T> find(Class<T> t,String sql,String sql2,int currentPage,int pageSize){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		Pager<T> pages = new Pager<T>();
		try {
			if(currentPage<=0)currentPage=1;
			int start =(currentPage-1)*pageSize;
			con=CreateConnection.getConnection();
			sql +="LIMIT ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			List<T> list = new ArrayList<T>();
			while(rs.next()){
				T tt = t.newInstance();
				this.getObject(tt, rs);
				list.add(tt);
			}	
			pages.setList(list);
			rs.close();
			ps.close();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			rs.next();
			int totalRecord = rs.getInt("count");
			int totalPage;
			if(totalRecord%pageSize==0) {
				totalPage=totalRecord/pageSize;
			}else {
				totalPage=totalRecord/pageSize+1;
			}
			
			pages.setTotalRecord(totalRecord);
			pages.setCurrentPage(currentPage);
			pages.setPageSize(pageSize);
			pages.setTotoalPage(totalPage);
		}  catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CreateConnection.close(rs);
			CreateConnection.closePreparedStatement(ps);
			CreateConnection.closeConnection(con);
		}
		
		return pages;
	}
	public void executeQuery(String sql,int... param){
		Connection con = null;
		PreparedStatement ps=null;
		try {
			con = CreateConnection.getConnection();
			ps= con.prepareStatement(sql);
			for(int i=0;i<param.length;i++) {
				ps.setInt(i+1, param[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CreateConnection.closePreparedStatement(ps);
			CreateConnection.closeConnection(con);
			
		}
	}

	public T load(T t,String sql,Object param) {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con=CreateConnection.getConnection();
			ps = con.prepareStatement(sql);
			if(param instanceof String) {
				ps.setString(1, (String)param);
			}else if(param instanceof Integer){
				ps.setInt(1, (int)param);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				this.getObject(t, rs);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CreateConnection.close(rs);
			CreateConnection.closePreparedStatement(ps);
			CreateConnection.closeConnection(con);
		}
		return t;
	}

	public T search() {
		return null;
	}
}
