package action.distributor;

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
import cn.bean.Goods;
import cn.bean.Type;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.dao.impl.TypeDaoImpl;


@WebServlet("/GoodsOfDis")
public class GoodsOfDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GoodsOfDis() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//分销商查看自己所有商品信息
		GoodsDaoImpl gd=new GoodsDaoImpl();
		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		if(Dis==null) {
			request.getRequestDispatcher("DistributorLogin.jsp").forward(request, response);
		}
		else {
			
			response.setContentType("application/json; charset=utf-8");  
	        response.setCharacterEncoding("UTF-8"); 
			String goodsJson=JSON.toJSONString(gd.findGoodsByDid(Dis.getId(), 1));//暂定第一页
			OutputStream out = response.getOutputStream();  
	        out.write(goodsJson.getBytes("UTF-8"));  
	        out.flush();
			
			/*List<Goods> g=gd.findGoodsByDid(Dis.getId());	
			for(Goods ls:g) {
				
				Distributor dis=new DistributorDaoImpl().findDisById(ls.getDistributorid());
				List<Object> li=new ArrayList<Object>();
				li.add(dis);
				request.setAttribute("distributor", li);
			}
			for(Goods go:g) {
				System.out.println(go.getName()+","+go.getDescription());
			}
			TypeDaoImpl tp=new TypeDaoImpl();
			List<Type> t=tp.findAllType();	
			request.setAttribute("type", t);
			request.setAttribute("allgoods", g);
			request.getRequestDispatcher("index.jsp").forward(request, response);*/
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
