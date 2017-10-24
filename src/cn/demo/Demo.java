package cn.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import cn.bean.Area;
import cn.bean.Distributor;
import cn.bean.Goods;
import cn.bean.Level;
import cn.bean.Log;
import cn.bean.Manager;
import cn.bean.State;
import cn.bean.Suggestion;
import cn.bean.Type;
import cn.dao.impl.AreaDaoImpl;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.dao.impl.LevelDaoImpl;
import cn.dao.impl.LogDaoImpl;
import cn.dao.impl.ManagerDaoImpl;
import cn.dao.impl.StateDaoImpl;
import cn.dao.impl.SuggestionDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.help.Help;
import cn.help.Page;
import cn.help.TwoDimension;
import cn.help.UpLog;


public class Demo {
	
	@Test
	public void shaixuan(){
		
		int[] a= {1,3,4,5,6,7,10,12,15,16,22,28,29,30,31,35,36,37,38,39};
		int[] b= {2,3,4,8,10,12,16,18,20,22};
		List<Object> list=new ArrayList<Object>();
		if(a.length>b.length) {
			for(int i=0;i<a.length;i++){
				for(int j=0;j<b.length;j++) {
					if(a[i]>=b[j]&&a[i]<=b[b.length-1-j]) {
						if(a[i]==b[j]||a[i]==b[b.length-1-j]) {
							list.add(a[i]);
						}
					}
				}
			}
		}else {
			
		}
		System.out.println(list);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void shai() {
		int[] b= {1,3,4,5,6,7,10,12,15,16,22,28,29,30,31,35,36,37,38,39};
		List list=new ArrayList<>();
		for(int i=0;i<b.length;i++) {
			for(int j=i+1;j<b.length;j++) {
				for(int k=j+1;k<b.length;k++) {
					if(b[k]==b[i]+b[j]) {
						list.add(b[k]);
						System.out.println(b[k]+"="+b[i]+"+"+b[j]);
					}
				}
			}
		}
		
		System.out.println(list);
		System.out.println(Collections.max(list));
		//水仙花数
		Scanner input=new Scanner(System.in);
		System.out.println("请输入第一个数字：");
		int N1=input.nextInt();
		System.out.println("请输入第二个数字：");
		int N2=input.nextInt();
		if((N1>100)&&(N2>100)) {
			for(int z=N1;z<N2;z++) {
				
				int a1=z/100;
				
				int a2=(z-100*a1)/10;
				
				int a3=z-100*a1-10*a2;
			
				if(z==(a1*a1*a1)+(a2*a2*a2)+(a3*a3*a3)) {
					System.out.println("水仙花数："+z);
				}
			}
		}
		
	}
	
	@Test
	public void areademo() {
		
		AreaDaoImpl ar=new AreaDaoImpl();
	/*	List<Area> area=ar.findAllArea();
		for(Area a:area) {
			System.out.println(a.getId()+","+a.getName()+","+a.getCityid());
		}*/
		System.out.println("-----------通过id查找区------------");
		Area a=ar.findAreaById(2);
		
		System.out.println(a.getId()+","+a.getName()+","+a.getCityid());
		
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void erweima() {
		TwoDimension td=new TwoDimension();
		td.QrcodeImg("weiyuan"+"你好", "D:/WY/cc/wy2.png");
		System.out.println("二维码生成");
		
	}
	@Test
	public void page() {
		Page p=new Page();
		GoodsDaoImpl g=new GoodsDaoImpl();
		p.setCount(g.findCountGoodsOfDis(2));
		int a=p.getCount();
		System.out.println(a);
	}
	@Test
	public void distributordemo() {
		/*DistributorDaoImpl dt=new DistributorDaoImpl();
		System.out.println("---------------查看所有分销商信息----------------");
		List<Distributor> dis=dt.findAllDis();
		for(Distributor d:dis) {
			System.out.println(d.getId()+","+d.getName()+","+d.getIdentity()+","+d.getInformation()+","+d.getLevelid());
		}
		System.out.println("----------------查看一个分销商信息-------------");
		Distributor di=dt.findDisById(3);
		System.out.println(di.getId()+","+di.getIdentity()+","+di.getName()+","+di.getInformation());*/
		System.out.println("--------------修改分销商信息---------------");
		DistributorDaoImpl dd=new DistributorDaoImpl();
		Distributor d=new Distributor();
		
		
		d.setCompany("天河农贸");
		d.setName("杜甫");
		d.setAddress("广州市天河区");
		d.setInformation("很好");
		d.setAreaid(1);
		d.setPhone("11011011011");
		boolean t=dd.changInf(d,7);
		if(t) {
			System.out.println("修改成功");
		}
		/*System.out.println("---------------添加分销商账号------------------");
		DistributorDaoImpl dt=new DistributorDaoImpl();
		
		boolean b=true;
		List<Distributor> di=dt.findAllDis();
		Distributor d=new Distributor();
		d.setName(null);
		d.setAddress(null);
		d.setCompany(null);
		d.setInformation(null);
		d.setPhone(null);
		d.setLevelid(2);
		d.setIdentity("Dali");
		d.setPassword("123456");
		d.setAreaid(1);
		
		for(Distributor dd:di) {
			if((d.getIdentity()).equals(dd.getIdentity())) {
				b=false;
			}
		}if(b) {
			dt.addDistributor(d);
			System.out.println("添加成功");
		}else {
			System.out.println("失败");
		}*/
		
		/*
		System.out.println("---------------删除分销商账号----------------");
		boolean det=dt.deleteDistributor(4);
		if(det) {
			System.out.println("删除成功");
		}
		System.out.println("---------------修改分销商权限----------------");
		dt.changeLvId(2, 3);*/
		
		/*DistributorDaoImpl dis=new DistributorDaoImpl();
		
		Page p=new Page();
		p.setCount(dis.findCountLog());
		p.setSize(3);
		p.setPageSize(0);
		p.setListDis(dis.findDisByCompany("大", 1));
		
		List<Distributor> d=p.getListDis();
		for(Distributor D:d) {
			System.out.println(D.getName());
		}*/
	}
	@Test
	public void leveldemo() {
		LevelDaoImpl l=new LevelDaoImpl();
		Level lv=l.findLvById(2);
		System.out.println(lv.getId()+","+lv.getName()+","+lv.getDescribe());
		
	}
	@Test
	public void managerdemo() {
		/*System.out.println("-----------管理员登录---------");
		ManagerDaoImpl mg=new ManagerDaoImpl();
		boolean msg=mg.FindManager("admin", "12345",1);
		if(msg) {
			System.out.println("登录成功");
		}
		else {
			System.out.println("账号或密码错误");
		}*/
		System.out.println("-----------管理员修改密码---------");
		ManagerDaoImpl mg=new ManagerDaoImpl();
		Manager m=mg.findMaByNa("admin");
		System.out.println(m.getManagerpwd());
		if("654321".equals(m.getManagerpwd())) {
			System.out.println(222);
			if("123".equals("123")) {
				boolean t=mg.changPwd(m.getId(), "123");
				if(t) {
					UpLog.Uplog("修改超级管理员密码", m.getName());
					System.out.println("修改成功");
				}
				else {
					System.out.println("修改失败");
				}
			}else {
				System.out.println("密码不一致");
			}
		}else {
			System.out.println("管理密码有误");
		}
		
		
	}
	@Test
	public void typedemo() {
		System.out.println("---------查看所有种类---------");
		TypeDaoImpl tp=new TypeDaoImpl();
		List<Type> T=tp.findAllType();
		for(Type t:T) {
			System.out.println(t.getId()+","+t.getName());
		}
	}
	@Test
	public void statedemo() {
		System.out.println("---------查看状态---------");
		StateDaoImpl st=new StateDaoImpl();
		State s=st.findStByid(1);
		System.out.println(s.getId()+","+s.getName());
	}
	@Test
	public void suggestiondemo() {
		SuggestionDaoImpl sg=new SuggestionDaoImpl();
		System.out.println("-----------查看所有意见建议---------");
		List<Suggestion> sug=sg.findAllSg();
		for(Suggestion s:sug) {
			System.out.println(s.getId()+","+s.getContent()+","+s.getDistributorid()+","+s.getStateid());
		}
		
		System.out.println("-----------根据id查看意见建议-----------");
		Suggestion s=sg.findSgById(2);
		System.out.println(s.getId()+","+s.getContent()+","+s.getDistributorid()+","+s.getStateid());
		
		System.out.println("------------根据状态查看意见建议-----------");
		List<Suggestion> sugg=sg.findSgByStId(1);
		for(Suggestion ss:sugg) {
			System.out.println(ss.getId()+","+ss.getContent()+","+ss.getDistributorid()+","+ss.getStateid());
		}
		
		System.out.println("-------------修改意见建议的状态-----------");
		boolean s2=sg.changSt(1,2);
		if(s2) {
			System.out.println("修改成功,新的意见如下");
			List<Suggestion> sug1=sg.findAllSg();
			for(Suggestion sss:sug1) {
				System.out.println(sss.getId()+","+sss.getContent()+","+sss.getDistributorid()+","+sss.getStateid());
			}
		}else {
			System.out.println("修改失败");
		}
	}
	@Test
	public void goodsdemo() {
		GoodsDaoImpl goods=new GoodsDaoImpl();
		System.out.println("-------------查看所有商品----------");
		List<Goods> gd=goods.findAllGoods();
		for(Goods g:gd) {
			System.out.println(g.getId()+","+g.getName()+","+g.getPhoto()+","+g.getDescription()+","+g.getTid()+","+g.getDistributorid()+","+g.getTime());
		}
		/*System.out.println("-----------根据商品类型id查看商品-----------");
		List<Goods> gd1=goods.findGoodsByTid(1);
		for(Goods g:gd1) {
			System.out.println(g.getId()+","+g.getName()+","+g.getPhoto()+","+g.getDescription()+","+g.getTid()+","+g.getDistributorid());
		}
		System.out.println("------------根据分销商id查看商品----------");
		List<Goods> gd2=goods.findGoodsByDid(1);
		for(Goods g:gd2) {
			System.out.println(g.getId()+","+g.getName()+","+g.getPhoto()+","+g.getDescription()+","+g.getTid()+","+g.getDistributorid());
		}
		System.out.println("------------通过商品id查看商品-----------");
		Goods gg=goods.findGoodsById(1);
		System.out.println(gg.getId()+","+gg.getName()+","+gg.getPhoto()+","+gg.getDescription()+","+gg.getTid()+","+gg.getDistributorid());
		System.out.println("-------------关键字查询--------------");
		List<Goods> gd3=goods.UnClearSearchGoods("籽");
		for(Goods g:gd3) {
			System.out.println(g.getId()+","+g.getName()+","+g.getPhoto()+","+g.getDescription()+","+g.getTid()+","+g.getDistributorid());
		}*/
		System.out.println("--------------添加商品--------------");
		Goods newgoods=new Goods();
		newgoods.setName("花菜");
		newgoods.setPhoto("D");
		newgoods.setDescription("非常好吃！");
		newgoods.setTid(2);
		newgoods.setDistributorid(3);
		newgoods.setCity(2);
		newgoods.setTime(Help.StampToday(Help.getTime()));
		boolean f=goods.addGoods(newgoods);
		if(f) {
			System.out.println("添加成功 ");
		}else {
			System.out.println("添加失败");
		}
		System.out.println("------------修改商品信息-----------");
//		Goods newgoods=new Goods();
//		newgoods.setName("花菜");
//		newgoods.setPhoto("D");
//		newgoods.setDescription("非常好吃！");
//		newgoods.setTid(2);
//		newgoods.setDistributorid(3);
//		newgoods.setId(5);
//		boolean f=goods.updateGoods(newgoods);
//		if(f) {
//			System.out.println("修改成功 ");
//		}else {
//			System.out.println("修改失败");
//		}
		/*System.out.println("------------删除商品------------");
		boolean t=goods.deleteGoods(6);
		if(t) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}*/
	}
	@Test
	public void log(){
		LogDaoImpl log=new LogDaoImpl();
		System.out.println("-----------添加日志----------");
		Log logs=new Log();
		
		logs.setRecord("删除商品");
		logs.setOperator("老李");
		
		
		boolean t=log.UpdateLog(logs);
		if(t) {
			System.out.println("添加成功");
		}else {
			System.out.println("失败");
		}
	}
	@Test
	public void addGoods() {
		
	}
}
