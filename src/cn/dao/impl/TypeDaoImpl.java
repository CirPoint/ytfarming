package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Type;
import cn.dao.TypeDao;
import cn.dbc.BaseDao;

public class TypeDaoImpl implements TypeDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	@Override
	public List<Type> findAllType() {
		List<Type> Tp=new ArrayList<Type>();
		String sql="select * from type";
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Type tp=new Type();
				tp.setId(rs.getInt("id"));
				tp.setName(rs.getString("name"));
				Tp.add(tp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return Tp;
	}

	@Override
	public Type findTypeById(int id) {
		Type tp=new Type();
		String sql="select * from type where id=?";
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				tp.setId(rs.getInt("id"));
				tp.setName(rs.getString("name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return tp;
	}

}
