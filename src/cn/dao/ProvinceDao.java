package cn.dao;

import java.util.List;

import cn.bean.Province;

public interface ProvinceDao {
	//查找所有省份
	public List<Province> findAll();
	//根据id查找省份
	public Province findProById(int id);

	
}
