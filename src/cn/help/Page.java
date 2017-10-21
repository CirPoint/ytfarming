package cn.help;

import java.util.List;

import cn.bean.Distributor;
import cn.bean.Goods;
import cn.bean.Log;

public class Page {
	private int count;
	private int size;
	private int pageSize;
	private int pageIndex=1;
	private boolean hasNextPage;
	private boolean hasUpPage;
	private List<Log> listLog;
	private List<Goods> listGoods;
	private List<Distributor> listDis;
	
	public Page() {
		super();
	}
	
	public Page(int count, int size, int pageSize, int pageIndex, boolean hasNextPage, boolean hasUpPage,
			List<Log> listLog, List<Goods> listGoods, List<Distributor> listDis) {
		super();
		this.count = count;
		this.size = size;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.hasNextPage = hasNextPage;
		this.hasUpPage = hasUpPage;
		this.listLog = listLog;
		this.listGoods = listGoods;
		this.listDis = listDis;
	}
	//数据条数
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//每页条数
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	//总页数
	public int getPageSize() {	
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		pageSize=(count%size==0)?(count/size):(count/size+1);
		this.pageSize = pageSize;
	}
	//当前页码
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	//上一页
	public boolean isHasUpPage() {
		hasUpPage=(pageIndex-1==0)?false:true;
		
		return hasUpPage;
	}
	public void setHasUpPage(boolean hasUpPage) {
		this.hasUpPage = hasUpPage;
	}
	//下一页
	public boolean isHasNextPage() {
		hasNextPage=(pageSize-pageIndex==0)?false:true;	
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public List<Goods> getListGoods() {
		return listGoods;
	}
	public void setListGoods(List<Goods> listGoods) {
		this.listGoods = listGoods;
	}
	public List<Distributor> getListDis() {
		return listDis;
	}
	public void setListDis(List<Distributor> listDis) {
		this.listDis = listDis;
	}
	public List<Log> getListLog() {
		return listLog;
	}
	public void setListLog(List<Log> listLog) {
		this.listLog = listLog;
	}
	
	
}
