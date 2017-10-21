package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Manager;
import cn.dao.ManagerDao;
import cn.dbc.BaseDao;

public class ManagerDaoImpl implements ManagerDao {
	BaseDao bs=new BaseDao();
	Connection conn=bs.getConn();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public boolean FindManager(String username, String password,int levelid) {
		boolean f=false;
		String sql="select * from manager where name=? and password=? and levelid=?"; 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setInt(3, levelid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return f;
	}

	@Override
	public boolean changPwd(int id,String newpassword) {
		boolean f=false;
		String sql="update manager set password=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(newpassword);
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0)
		{
			f=true;
		}
		return f;
	}

	@Override
	public Manager findMaByNa(String name) {
		Manager mg=new Manager();
		String sql="select * from manager where name=?";
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mg.setId(rs.getInt("id"));
				mg.setName(rs.getString("name"));
				mg.setPassword(rs.getString("password"));
				mg.setLevelid(rs.getString("levelid"));
				mg.setManagerpwd(rs.getString("managerpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		
		return mg;
	}

}
