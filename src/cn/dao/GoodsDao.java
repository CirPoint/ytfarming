package cn.dao;

import java.util.List;

import cn.bean.Goods;

public interface GoodsDao {
	//显示所有商品名字
	public List<Goods> findAllGoods();
	//根据商品类型查看商品
	public List<Goods> findGoodsByTid(int tid);
	//根据分销商id查看商品
	public List<Goods> findGoodsByDid(int did,int pageIndex);
	//根据商品id查看商品信息
	public Goods findGoodsById(int id);
	//关键字查询商品
	public List<Goods> UnClearSearchGoods(String keyWord);
	//修改商品信息
	public boolean updateGoods(Goods newGoods);
	//添加商品
	public boolean addGoods(Goods newGoods);
	//通过id删除商品
	public boolean deleteGoods(int id);
	//分销商查看自己的某类商品信息
	public List<Goods> findGoodsByTidId(int tid,int did);
	//商品文章上传
	public boolean updateGoodsDes(Goods newgoods,String description,int id);
	//商品分页
	public List<Goods> findGoodsInfWithLine(int startIndex,int endIndex);
	
	
}
