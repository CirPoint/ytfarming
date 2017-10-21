package cn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	public Connection conn=null;
	public PreparedStatement pstmt=null;
	public ResultSet rs=null;
	
	
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ytny", "root", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	public void closeConn(Connection conn, PreparedStatement  pstmt ,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int update(String sql,List<Object> list)
	{
		int num = 0;
		try
		{
			pstmt = getConn().prepareStatement(sql);
			if(list!=null)
			{
				for(int i=0;i<list.size();i++)
				{
					pstmt.setObject(i+1,list.get(i));
				}
			}
			num = pstmt.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			closeConn(conn, pstmt, rs);
		}
		return num;
	}
}
