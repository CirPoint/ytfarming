package action.user;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.bean.Distributor;
import cn.bean.Goods;
import cn.bean.Type;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.help.Page;

@WebServlet("/ShowAllGoods")
public class ShowAllGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAllGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("所有商品");
		DistributorDaoImpl mg=new DistributorDaoImpl();
		//获取扫码得到的分销商ID
	/*	int distributorid=Integer.parseInt(request.getParameter("distributorid"));
		HttpSession session=request.getSession();
		Distributor dis=mg.findDisById(distributorid);*/
		//该分销商放入session中
	//	session.setAttribute("distributor", dis);
		
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
		
		GoodsDaoImpl goods=new GoodsDaoImpl();
		
		int pageIndex=Integer.parseInt(request.getParameter("pageindex"));
		Page pg=new Page();
		pg.setCount(goods.findCountGoodsOfDis(1));//暂定为1号分销商
		pg.setSize(8);
		pg.setPageSize(0);
		System.out.println(pg.getPageSize()+";页码"+pageIndex);
		if(pageIndex>pg.getPageSize()) {
			System.out.println("已经是尾页啦！");
		}else {
			pg.setPageIndex(pageIndex);
			pg.setListGoods(goods.findGoodsByDid(1, pageIndex));//分页
			request.setAttribute("pagebean",pg);
			String userJson=JSON.toJSONString(pg.getListGoods());
		//	String userJson=JSON.toJSONString(goods.findGoodsByDid(1, pageIndex));//获取该商品
			OutputStream out = response.getOutputStream();  
	        out.write(userJson.getBytes("UTF-8"));  
	        out.flush();
		}
		

	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
