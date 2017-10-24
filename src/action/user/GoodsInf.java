package action.user;

import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Goods;
import cn.bean.Type;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.dao.impl.TypeDaoImpl;

@WebServlet("/GoodsInf")
public class GoodsInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsInf() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("查看商品详细信息");
	
		int GoodsId=Integer.parseInt(request.getParameter("GoodsId"));
		int TypeId=Integer.parseInt(request.getParameter("TypeId"));
		
		GoodsDaoImpl goodsinf=new GoodsDaoImpl();
		Goods gd=goodsinf.findGoodsById(GoodsId);
		
		
		TypeDaoImpl tp=new TypeDaoImpl();
		Type t=tp.findTypeById(TypeId);
		
		OutputStream out = response.getOutputStream(); 
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");
        //商品信息
        String goodsJson=JSON.toJSONString(goodsinf.findGoodsById(GoodsId));
		//商品类型
        String typeJson=JSON.toJSONString(tp.findTypeById(TypeId));
        //分销商
        DistributorDaoImpl dis=new DistributorDaoImpl();
        int DisId=Integer.parseInt(request.getParameter("DisId"));
        String disJson=JSON.toJSONString(dis.findDisById(DisId));
        
        out.write(disJson.getBytes("UTF-8"));
        out.write(typeJson.getBytes("UTF-8"));
        out.write(goodsJson.getBytes("UTF-8"));
        out.flush();
        
		
		
		
		/*List<Object> list=new ArrayList<>();
		List<Object> type=new ArrayList<>();
		
		type.add(t);		
		list.add(gd);
		request.setAttribute("goodsinf", list);
		request.setAttribute("type", type);
		request.getRequestDispatcher("GoodsInf.jsp").forward(request, response);*/
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
