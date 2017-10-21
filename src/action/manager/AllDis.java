package action.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Distributor;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.help.Page;


@WebServlet("/AllDis")
public class AllDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AllDis() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("所有分销商");
		boolean f=false;		//标记
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
       
        int pageIndex=Integer.parseInt(request.getParameter("index"));
        DistributorDaoImpl dis=new DistributorDaoImpl();
        Page p=new Page();
        
        p.setCount(dis.findCountLog());
        p.setSize(2);
        p.setPageSize(0);
        p.setListDis(dis.findAllDis(pageIndex));
        p.setPageIndex(pageIndex);
		request.setAttribute("pagebean", p);
		request.getRequestDispatcher("fenyeTest1.jsp").forward(request, response);
        
        
        
		/*
		//商家
		DistributorDaoImpl dis=new DistributorDaoImpl();
		String userJson=JSON.toJSONString(dis.findAllDis());	
		//商品数
		List<Object> count=new ArrayList<Object>();
		List<Distributor> list=dis.findAllDis();
		for(Distributor l:list) {
			Page p=new Page();
			GoodsDaoImpl g=new GoodsDaoImpl();
			p.setCount(g.findCountGoodsOfDis(l.getId()));
			count.add(p.getCount());
			
		}
		String countJson=JSON.toJSONString(count);
		OutputStream out = response.getOutputStream();  
		
		out.write(countJson.getBytes("UTF-8"));
        out.write(userJson.getBytes("UTF-8"));  
        out.flush(); */ 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
