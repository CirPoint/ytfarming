package cn.dao.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Log;
import cn.dao.LogDao;
import cn.dbc.BaseDao;
import cn.help.Help;

public class LogDaoImpl implements LogDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public List<Log> findAll() {
		List<Log> log=new ArrayList<Log>();
		conn=bs.getConn();
		String sql="select * from log";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Log l=new Log();
				l.setId(rs.getInt("id"));
				l.setTime(rs.getString("time"));
				l.setRecord(rs.getString("record"));
				l.setOperator(rs.getString("operator"));
				l.setIp(rs.getString("ip"));
				log.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return log;
	}

	@Override
	public List<Log> findLogByTime(String Time) {
		List<Log> log=new ArrayList<Log>();
		conn=bs.getConn();
		String sql="select * from log where time=? ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Time);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Log l=new Log();
				l.setId(rs.getInt("id"));
				l.setTime(rs.getString("time"));
				l.setRecord(rs.getString("record"));
				l.setOperator(rs.getString("operator"));
				l.setIp(rs.getString("ip"));
				log.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return log;
	}

	@Override
	public boolean UpdateLog(Log log) {
		boolean f=false;
		try {
			//获取当前时间并转化为标准形式
			long timenum=Help.getTime();
			String stimr=Help.StampTodate(timenum);
			log.setTime(stimr);
			//获取当前操作的ip地址
			String nip=InetAddress.getLocalHost().getHostAddress();
			log.setIp(nip);
			String sql="insert into log (id,time,record,operator,ip) values(?,?,?,?,?)";
			List<Object> list=new ArrayList<Object>();
			list.add(log.getId());
			list.add(log.getTime());
			list.add(log.getRecord());
			list.add(log.getOperator());
			list.add(log.getIp());
			int num=bs.update(sql, list);
			if(num>0) {
				f=true;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean DeletLog(int id) {
		boolean f=false;
		String sql="delete from log where id=?";
		List<Object> list =new ArrayList<Object>();
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0)
		{
			f=true;
		}
		return f;
	}
	@Override
	public List<Log> findLogInfoWithLine(int PageIndex) {
		
		
		List<Log> list=new ArrayList<Log>();
		String sql="select * from log limit ?,10";
		try
		{
			conn=bs.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (PageIndex-1)*10);
		
			rs=pstmt.executeQuery();
			while(rs.next()){
				Log l=new Log();
				l.setId(rs.getInt("id"));
				l.setTime(rs.getString("time"));
				l.setRecord(rs.getString("record"));
				l.setOperator(rs.getString("operator"));
				l.setIp(rs.getString("ip"));
				list.add(l);
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	public int findCountLog()
	{
		
		
		String sql="select count(*) si from  log";
		try
		{
			conn=bs.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				return rs.getInt("si");
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			bs.closeConn(conn, pstmt, rs);
		}
		
		return 0;
	}


}
