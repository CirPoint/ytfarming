package cn.dao;

import java.util.List;


import cn.bean.Log;

public interface LogDao {
	//查看所有日志
	public List<Log> findAll();
	//根据日期查看日志
	public List<Log> findLogByTime(String Time);
	//添加日志
	public boolean UpdateLog(Log log);
	//删除日志
	public boolean DeletLog(int id);
	//日志分页
	public List<Log> findLogInfoWithLine(int pageIndex);
	
}
