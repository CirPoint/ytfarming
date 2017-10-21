package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.Level;
import cn.dao.LevelDao;
import cn.dbc.BaseDao;

public class LevelDaoImpl implements LevelDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	@Override
	public Level findLvById(int id) {
		Level lv=new Level();
		String sql="select * from level where id=?";
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				lv.setId(rs.getInt("id"));
				lv.setName(rs.getString("name"));
				lv.setDescribe(rs.getString("describe"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return lv;
	}

}
