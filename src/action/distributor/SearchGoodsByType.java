package action.distributor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Goods;
import cn.dao.impl.GoodsDaoImpl;

@WebServlet("/SearchGoodsByType")
public class SearchGoodsByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchGoodsByType() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("按照类型查找产品");
		boolean f=false; //标记
		OutputStream out = response.getOutputStream(); 
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");
        
        String tid=request.getParameter("tid");
		GoodsDaoImpl goods=new GoodsDaoImpl();
		if(tid.equals("请选择")) {
			String allgoodsJson=JSON.toJSONString(goods.findAllGoods());
			out.write(allgoodsJson.getBytes("UTF-8"));
		    out.flush();

		}
		else {
			int TypeId1=Integer.parseInt(tid);//获取类型id值
			//商品信息
		    String goodsJson=JSON.toJSONString(goods.findGoodsByTid(TypeId1));
		    
		    out.write(goodsJson.getBytes("UTF-8"));
		    out.flush();

		}
	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
