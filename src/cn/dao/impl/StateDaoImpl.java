package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.State;
import cn.dao.StateDao;
import cn.dbc.BaseDao;

public class StateDaoImpl implements StateDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public State findStByid(int id) {
		State st=new State();
		conn=bs.getConn();
		String sql="select * from state where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

}
