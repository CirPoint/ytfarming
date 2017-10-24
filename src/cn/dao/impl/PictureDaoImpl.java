package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.bean.Picture;
import cn.dao.PictureDao;
import cn.dbc.BaseDao;

public class PictureDaoImpl implements PictureDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public List<Picture> findPicByGoodsid(int goodsid) {
		List<Picture> pic=new ArrayList<Picture>();
		String sql="select * from picture where goodsid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, goodsid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Picture c=new Picture();
				c.setId(rs.getInt("id"));
				c.setPhoto(rs.getString("photo"));
				c.setGoodsid(rs.getInt("goodsid"));
				pic.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pic;
	}

	@Override
	public boolean UpdatePic(Picture picture) {
		boolean f=false;
		String sql="insert into picture (id,photo,goodsid) values(?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(picture.getId());
		list.add(picture.getPhoto());
		list.add(picture.getGoodsid());
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}

	@Override
	public boolean DeletPic(int id) {
		boolean f=false;
		String sql="delete from picture where id=?";
		List<Object> list =new ArrayList<Object>();
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0)
		{
			f=true;
		}
		return f;
	}

}
