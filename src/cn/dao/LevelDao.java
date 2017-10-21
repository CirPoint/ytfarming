package cn.dao;

import cn.bean.Level;

public interface LevelDao {
	//根据级别id显示级别
	public Level findLvById(int id);
}
