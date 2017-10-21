package cn.dao;

import java.util.List;

import cn.bean.City;

public interface CityDao {
	//根据省份id查找市区
	public List<City> findCityByProID(int proID);
	//根据市id查找市
	public City findCityByCid(int CityID);
	
}
