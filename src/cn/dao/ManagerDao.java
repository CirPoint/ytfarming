package cn.dao;

import cn.bean.Manager;

public interface ManagerDao {
	//登录
	public boolean FindManager(String username,String password,int levelid );
	//修改密码
	public boolean changPwd(int id,String newpassword);
	
	public Manager findMaByNa(String name);
}
