package com.wangyang.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wangyang.model.Pager;
import com.wangyang.model.Schedule;
import com.wangyang.mysql.CreateConnection;

import jxl.Cell;

public class ScheduleDao extends BaseDao<Schedule> implements IScheduleDao {
	
	PrintWriter out=null;
	@Override
	public void setOut(PrintWriter out) {
		this.out=out;
	}
	
	
	@Override
	public int[] add(Cell[] cells) {
		int result[]= {};
		Connection con = null;
		PreparedStatement ps=null;
		try {
			con = CreateConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM `schedule`");
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("INSERT INTO `slw`.`schedule`(`classid`, `classname`) VALUES (?, ?)");
			for(int i=0;i<cells.length;i++) {
				ps.setInt(1, i);
				ps.setString(2, cells[i].getContents());
				ps.addBatch();
				if(out!=null) {
					out.write("正在插入第"+i+"条数据!!");
				}
			}
			result =ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CreateConnection.closePreparedStatement(ps);
			CreateConnection.closeConnection(con);
			
		}return result;
	}

	@Override
	public int findClass(String classname) {
		String sql="SELECT *FROM `schedule` WHERE CLASSNAME=?";
		
		return super.load(new Schedule(), sql, classname).getClassid();
	}

	@Override
	public Pager<Schedule> find(String condition,int currentpage,int pagesize) {
		String sql="SELECT * FROM `schedule` ";
		String sql2="select count(*)as count from schedule ";
		if(condition!=null||!"".equals(condition)) {
			sql+="WHERE classname like '%"+condition+"%'";
			sql2+="WHERE classname like '%"+condition+"%'";
		}
		return super.find(Schedule.class, sql, sql2,currentpage,pagesize);
	}
	
}
