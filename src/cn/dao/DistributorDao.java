package cn.dao;

import java.util.List;

import cn.bean.Distributor;

public interface DistributorDao {
	//查看所有分销商无分页
	public  List<Distributor> findAllDis();
	//查看所有分销商
	public List<Distributor> findAllDis(int pageIndex);
	//根据分销商id查看分销商个人信息
	public Distributor findDisById(int id);
	//修改分销商密码
	public boolean UpdatPassword(int id,String newpassword);
	//分销商自己修改个人信息
	public boolean changInf(Distributor newinf,int id);
	//管理员添加分销商账号
	public boolean addDistributor(Distributor newdis);
	//管理员根据id删除分销商账号
	public boolean deleteDistributor(int id);
	//管理员修改分销商权限
	public boolean  changeLvId(int id,int levelid);
	//管理员冻结分销商账号(3级权限类似于冻结)
	public boolean finDis(String identity,String password);
	//根据账号查看分销商信息
	public Distributor findDisByIden(String Iden);
	//根据商家名模糊查看分销商
	public List<Distributor> findDisByCompany(String companySearching,int pageIndex);
	//根据联系人模糊查看分销商
	public List<Distributor> findDisByName(String nameSearching,int pageIndex);
	//根据地址模糊查看分销商
	public List<Distributor> findDisByAddress(String addressSearching,int pageIndex);
	//根据账号模糊查找分销商
	public List<Distributor> findDisByIdentity(String identitySearching,int pageIndex);
	//区域查找分销商
	public List<Distributor> findDisByAreaID(int pageIndex,int areaid);
	
	
}
