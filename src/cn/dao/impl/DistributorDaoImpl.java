package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Distributor;
import cn.dao.DistributorDao;
import cn.dbc.BaseDao;

public class DistributorDaoImpl implements DistributorDao {
	BaseDao bs=new BaseDao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public int findCountLog()
	{
		
		
		String sql="select count(*) si from  distributor";
		try
		{
			conn=bs.getConn();
			pstmt=conn.prepareStatement(sql);
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
	//查看所有分销商
	@Override
	public List<Distributor> findAllDis(int pageIndex) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor limit ?,10";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Distributor dist=new Distributor();
				dist.setId(rs.getInt(1));
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dis.add(dist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	//根据分销商id查看分销商个人信息
	@Override
	public Distributor findDisById(int id) {
		Distributor dist=new Distributor();
		conn=bs.getConn();
		String sql="select * from distributor where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dist.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dist;
	}
	//分销商自己修改个人信息
	@Override
	public boolean changInf(Distributor newinf,int id) {
		boolean f=false;
		String sql="update distributor set name=?,address=?,information=?,phone=?,company=?,areaid=? where id=?";
		List<Object> list=new ArrayList<Object>();
		
		list.add(newinf.getName());
		list.add(newinf.getAddress());
		list.add(newinf.getInformation());
		list.add(newinf.getPhone());
		list.add(newinf.getCompany());
		list.add(newinf.getAreaid());
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}
	//管理员添加分销商账号
	@Override
	public boolean addDistributor(Distributor newdis) {
		boolean f=false;
		String sql="insert into distributor (id,identity,password,name,address,information,levelid,phone,company,areaid) values(?,?,?,?,?,?,?,?,?,?)";
		List<Object> list=new ArrayList<Object>();
		list.add(newdis.getId());
		list.add(newdis.getIdentity());
		list.add(newdis.getPassword());
		list.add(newdis.getName());
		list.add(newdis.getAddress());
		list.add(newdis.getInformation());
		list.add(newdis.getLevelid());
		list.add(newdis.getPhone());
		list.add(newdis.getCompany());
		list.add(newdis.getAreaid());
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}
	//管理员根据id删除分销商账号
	@Override
	public boolean deleteDistributor(int id) {
		boolean f=false;
		String sql="delete from distributor where id=?";
		List<Object> list =new ArrayList<Object>();
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0)
		{
			f=true;
		}
		return f;
	}
	//管理员修改分销商权限
	@Override
	public boolean changeLvId(int id, int levelid) {
		boolean f=false;
		String sql="update distributor set levelid=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(levelid);
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}
	@Override
	public boolean finDis(String identity, String password) {
		boolean f=false;
		String sql="select * from distributor where identity=? and password=?"; 
		try {
			conn=bs.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, identity);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return f;
	}
	@Override
	public Distributor findDisByIden(String Iden) {
		Distributor dist=new Distributor();
		conn=bs.getConn();
		String sql="select * from distributor where identity=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, Iden);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dist.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dist;
	}
	@Override
	public List<Distributor> findDisByAreaID(int pageIndex,int areaid) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor where areaid=? limit ?,10";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, areaid);
			pstmt.setInt(2, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Distributor dist=new Distributor();
				dist.setId(rs.getInt(1));
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dis.add(dist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public List<Distributor> findDisByCompany(String companySearching,int pageIndex) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor where company like '%"+companySearching+"%' limit ?,10";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Distributor dist=new Distributor();
				dist.setId(rs.getInt("id"));
				dist.setIdentity(rs.getString("identity"));
				dist.setPassword(rs.getString("password"));
				dist.setName(rs.getString("name"));
				dist.setAddress(rs.getString("address"));
				dist.setInformation(rs.getString("information"));
				dist.setLevelid(rs.getInt("levelid"));
				dist.setPhone(rs.getString("phone"));
				dist.setCompany(rs.getString("company"));
				dist.setAreaid(rs.getInt("areaid"));
				dis.add(dist);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public List<Distributor> findDisByName(String nameSearching,int pageIndex) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor where name like '%"+nameSearching+"%' limit ?,10";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Distributor dist=new Distributor();
				dist.setId(rs.getInt(1));
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dis.add(dist);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public List<Distributor> findDisByAddress(String addressSearching,int pageIndex) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor where address like '%"+addressSearching+"%' limit ?,10";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Distributor dist=new Distributor();
				dist.setId(rs.getInt(1));
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dis.add(dist);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public List<Distributor> findDisByIdentity(String identitySearching,int pageIndex) {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor where identity like '%"+identitySearching+"%' limit ?,10";
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (pageIndex-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Distributor dist=new Distributor();
				dist.setId(rs.getInt("id"));
				dist.setIdentity(rs.getString("identity"));
				dist.setPassword(rs.getString("password"));
				dist.setName(rs.getString("name"));
				dist.setAddress(rs.getString("address"));
				dist.setInformation(rs.getString("information"));
				dist.setLevelid(rs.getInt("levelid"));
				dist.setPhone(rs.getString("phone"));
				dist.setCompany(rs.getString("company"));
				dist.setAreaid(rs.getInt("areaid"));
				dis.add(dist);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public List<Distributor> findAllDis() {
		List<Distributor> dis=new ArrayList<Distributor>();
		conn=bs.getConn();
		String sql="select * from distributor";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Distributor dist=new Distributor();
				dist.setId(rs.getInt(1));
				dist.setIdentity(rs.getString(2));
				dist.setPassword(rs.getString(3));
				dist.setName(rs.getString(4));
				dist.setAddress(rs.getString(5));
				dist.setInformation(rs.getString(6));
				dist.setLevelid(rs.getInt(7));
				dist.setPhone(rs.getString(8));
				dist.setCompany(rs.getString(9));
				dist.setAreaid(rs.getInt(10));
				dis.add(dist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bs.closeConn(conn, pstmt, rs);
		}
		return dis;
	}
	@Override
	public boolean UpdatPassword(int id, String newpassword) {
		boolean f=false;
		String sql="update distributor set password=? where id=?";
		List<Object> list=new ArrayList<Object>();
		list.add(newpassword);
		list.add(id);
		int num=bs.update(sql, list);
		if(num>0) {
			f=true;
		}
		return f;
	}

}
