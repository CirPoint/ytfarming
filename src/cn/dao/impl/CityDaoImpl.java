package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.City;

import cn.dao.CityDao;
import cn.dbc.BaseDao;

public class CityDaoImpl implements CityDao {
	BaseDao bs=new BaseDao();
	Connection conn=bs.getConn();
	PreparedStatement pstmt=null;
	ResultSet rs=null;	
	@Override
	public List<City> findCityByProID(int proID) {
		List<City> ct=new ArrayList<City>();
		String sql="select * from city where proid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, proID);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				City c=new City();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setProid(rs.getInt("proid"));
				ct.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}

	@Override
	public City findCityByCid(int CityID) {
		City c=new City();
		String sql="select * from city where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, CityID);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setProid(rs.getInt("proid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

}
