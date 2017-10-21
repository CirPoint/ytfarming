package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Area;
import cn.dao.AreaDao;
import cn.dbc.BaseDao;

public class AreaDaoImpl implements AreaDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public List<Area> findAllArea() {
		List<Area> ar=new ArrayList<Area>();
		conn=bs.getConn();
		String sql="select * from area";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Area area=new Area();
				area.setId(rs.getInt(1));
				area.setName(rs.getString(2));
				area.setCityid(3);
				ar.add(area);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return ar;
	}

	@Override
	public List<Area> findAreaByCityid(int cityid) {
		List<Area> area=new ArrayList<Area>();
		conn=bs.getConn();
		String sql="select * from area where cityid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cityid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Area ar=new Area(); 
				ar.setId(rs.getInt(1));
				ar.setName(rs.getString(2));
				ar.setCityid(cityid);
				area.add(ar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return area;
	}

	@Override
	public Area findAreaById(int id) {
		Area a=new Area();
		String sql="select * from area where id=?";
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setCityid(rs.getInt("cityid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
