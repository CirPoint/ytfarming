package cn.dao;

import java.util.List;

import cn.bean.Suggestion;

public interface SuggestionDao {
	//查看所有建议意见
	public List<Suggestion> findAllSg(); 
	//根据意见id查看建议意见
	public Suggestion findSgById(int id);
	//根据意见状态查看建议意见
	public List<Suggestion> findSgByStId(int Sid);
	//修改建议意见的状态
	public boolean changSt(int id,int newSid);
}
