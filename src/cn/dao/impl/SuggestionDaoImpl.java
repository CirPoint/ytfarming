package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Suggestion;
import cn.dao.SuggestionDao;
import cn.dbc.BaseDao;

public class SuggestionDaoImpl implements SuggestionDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//查看所有建议意见
	@Override
	public List<Suggestion> findAllSg() {
		List<Suggestion> sug=new ArrayList<>();
		conn=bs.getConn();
		String sql="select * from suggestion";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Suggestion sg=new Suggestion();
				sg.setId(rs.getInt("id"));
				sg.setContent(rs.getString("content"));
				sg.setDistributorid(rs.getInt("distributorid"));
				sg.setStateid(rs.getInt("stateid"));
				sug.add(sg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return sug;
	}
	//根据意见id查看建议意见
	@Override
	public Suggestion findSgById(int id) {
		Suggestion sg=new Suggestion();
		conn=bs.getConn();
		String sql="select * from suggestion where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sg.setId(rs.getInt("id"));
				sg.setContent(rs.getString("content"));
				sg.setDistributorid(rs.getInt("distributorid"));
				sg.setStateid(rs.getInt("stateid"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return sg;
	}
	//根据意见状态查看建议意见
	@Override
	public List<Suggestion> findSgByStId(int Sid) {
		List<Suggestion> sug=new ArrayList<>();
		conn=bs.getConn();
		String sql="select * from suggestion where stateid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Sid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Suggestion sg=new Suggestion();
				sg.setId(rs.getInt("id"));
				sg.setContent(rs.getString("content"));
				sg.setDistributorid(rs.getInt("distributorid"));
				sg.setStateid(rs.getInt("stateid"));	
				sug.add(sg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return sug;
	}
	//修改建议意见的状态
	@Override
	public boolean changSt(int id,int newSid) {
		boolean sg=false;
		conn=bs.getConn();
		String sql="update suggestion set stateid=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(newSid);
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0)
		{
			sg=true;
		}
		return sg;
	}

}
