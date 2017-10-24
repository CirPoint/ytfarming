package cn.dao;


import cn.bean.State;

public interface StateDao {
	//根据状态id显示相应状态
	public State findStByid(int id);
}
