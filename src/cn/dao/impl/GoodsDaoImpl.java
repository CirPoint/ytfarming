package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Goods;
import cn.dao.GoodsDao;
import cn.dbc.BaseDao;

public class GoodsDaoImpl implements GoodsDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//查看所有商品
	@Override
	public List<Goods> findAllGoods() {
		List<Goods> gd=new ArrayList<>();
		conn=bs.getConn();
		String sql="select * from goods";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPhoto(rs.getString("photo"));
				g.setDescription(rs.getString("description"));
				g.setTid(rs.getInt("tid"));
				g.setDistributorid(rs.getInt("distributorid"));
				g.setCity(rs.getInt("city"));
				g.setTime(rs.getString("time"));
				gd.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return gd;
	}
	//根据商品类型id查看商品
	@Override
	public List<Goods> findGoodsByTid(int tid) {
		List<Goods> gd=new ArrayList<>();
		conn=bs.getConn();
		String sql="select * from goods where tid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPhoto(rs.getString("photo"));
				g.setDescription(rs.getString("description"));
				g.setTid(rs.getInt("tid"));
				g.setDistributorid(rs.getInt("distributorid"));
				g.setCity(rs.getInt("city"));
				g.setTime(rs.getString("time"));
				gd.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		 return gd;
	}
	//根据分销商id查看商品
	@Override
	public List<Goods> findGoodsByDid(int did,int pageIndex) {
		 List<Goods> gd=new ArrayList<>();
		 conn=bs.getConn();
			String sql="select * from goods where distributorid=? limit ?,8";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, did);
				pstmt.setInt(2,( pageIndex-1)*8);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Goods g=new Goods();
					g.setId(rs.getInt("id"));
					g.setName(rs.getString("name"));
					g.setPhoto(rs.getString("photo"));
					g.setDescription(rs.getString("description"));
					g.setTid(rs.getInt("tid"));
					g.setDistributorid(rs.getInt("distributorid"));
					g.setCity(rs.getInt("city"));
					g.setTime(rs.getString("time"));
					gd.add(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				bs.closeConn(conn, pstmt, rs);
			}
		 return gd;
	}
	//通过商品id查看商品
	@Override
	public Goods findGoodsById(int id) {
		Goods g=new Goods();
		 conn=bs.getConn();
			String sql="select * from goods where id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					g.setId(rs.getInt("id"));
					g.setName(rs.getString("name"));
					g.setPhoto(rs.getString("photo"));
					g.setDescription(rs.getString("description"));
					g.setTid(rs.getInt("tid"));
					g.setDistributorid(rs.getInt("distributorid"));
					g.setCity(rs.getInt("city"));
					g.setTime(rs.getString("time"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				bs.closeConn(conn, pstmt, rs);
			}
		 return g;
	}
	//关键字查询商品
	@Override
	public List<Goods> UnClearSearchGoods(String keyWord) {
		 List<Goods> gd=new ArrayList<>();
		 conn=bs.getConn();
			String sql="select * from goods where name like '%"+keyWord+"%'";
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Goods g=new Goods();
					g.setId(rs.getInt("id"));
					g.setName(rs.getString("name"));
					g.setPhoto(rs.getString("photo"));
					g.setDescription(rs.getString("description"));
					g.setTid(rs.getInt("tid"));
					g.setDistributorid(rs.getInt("distributorid"));
					g.setCity(rs.getInt("city"));
					g.setTime(rs.getString("time"));
					gd.add(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				bs.closeConn(conn, pstmt, rs);
			}
		 return gd;
	}
	//修改某一个id商品的信息
	@Override
	public boolean updateGoods(Goods newGoods) {
		boolean f=false;
		String sql="update goods set name=?,photo=?,description=?,tid=?,distributorid=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(newGoods.getName());
		list.add(newGoods.getPhoto());
		list.add(newGoods.getDescription());
		list.add(newGoods.getTid());
		list.add(newGoods.getDistributorid());
		list.add(newGoods.getCity());
		list.add(newGoods.getId());
		list.add(newGoods.getTime());
		
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}
	//添加商品
	@Override
	public boolean addGoods(Goods newGoods) {
		boolean f=false;
		String sql="insert into goods (name,photo,description,tid,distributorid,city,time) values(?,?,?,?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(newGoods.getName());
		list.add(newGoods.getPhoto());
		list.add(newGoods.getDescription());
		list.add(newGoods.getTid());
		list.add(newGoods.getDistributorid());
		list.add(newGoods.getCity());
		list.add(newGoods.getTime());
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}
	//删除商品
	@Override
	public boolean deleteGoods(int id) {
		boolean f=false;
		String sql="delete from goods where id=?";
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
	public List<Goods> findGoodsByTidId(int tid, int did) {
		List<Goods> gd=new ArrayList<>();
		conn=bs.getConn();
		String sql="select * from goods where tid=? and distributorid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			pstmt.setInt(2, did);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPhoto(rs.getString("photo"));
				g.setDescription(rs.getString("description"));
				g.setTid(rs.getInt("tid"));
				g.setDistributorid(rs.getInt("distributorid"));
				g.setCity(rs.getInt("city"));
				g.setTime(rs.getString("time"));
				gd.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		 return gd;
	}
	@Override
	public List<Goods> findGoodsInfWithLine(int startIndex, int endIndex) {
		List<Goods> list=new ArrayList<>();
		
		String sql="select　* from goods limit 1,5";
		
		conn=bs.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, startIndex);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setTid(rs.getInt("tid"));
				g.setPhoto(rs.getString("photo"));
				g.setDescription(rs.getString("description"));
				g.setDistributorid(rs.getInt("distributorid"));
				g.setCity(rs.getInt("city"));
				g.setTime(rs.getString("time"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	public int findCountGoodsOfDis(int DisId)
	{
		
		
		String sql="select count(*) si from  goods where distributorid=?";
		try
		{
			conn=bs.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, DisId);
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
	@Override
	public boolean updateGoodsDes(Goods newgoods,String description,int id) {
		boolean f=false;
		String sql="update goods set description=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(newgoods.getDescription());
		list.add(newgoods.getId());
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}

}
