package cn.dao;

import java.util.List;

import cn.bean.Type;

public interface TypeDao {
	//查看所有类型
	public List<Type> findAllType();
	
	//根据类型id查看类型
	
	public Type findTypeById(int id);
}
