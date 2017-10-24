package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Province;
import cn.dao.ProvinceDao;
import cn.dbc.BaseDao;

public class ProvinceDaoImpl implements ProvinceDao {
	BaseDao bs=new BaseDao();
	Connection conn=bs.getConn();
	PreparedStatement pstmt=null;
	ResultSet rs=null;	
	@Override
	public List<Province> findAll() {
		List<Province> pro=new ArrayList<Province>();
		String sql="select * from province";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Province p=new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				pro.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pro;
	}

	@Override
	public Province findProById(int id) {
		Province p=new Province();
		String sql="select * from province where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

}
