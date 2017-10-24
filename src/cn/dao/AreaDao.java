package cn.dao;

import java.util.List;

import cn.bean.Area;

public interface AreaDao {
	//查看所有区域
	 public List<Area> findAllArea();
	//按照市区查询地区
	 public List<Area> findAreaByCityid(int cityid);
	 //根据id查找地区
	 public Area findAreaById(int id);
	 
}
