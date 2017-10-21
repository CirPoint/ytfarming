package action.user;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Distributor;
import cn.dao.impl.GoodsDaoImpl;

@WebServlet("/FindGoodsByType")
public class FindGoodsByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FindGoodsByType() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("按照类型查找产品");
		boolean f=false; //标记
		//获取session
//		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		//json
		OutputStream out = response.getOutputStream(); 
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8");
        //获取类型id
		GoodsDaoImpl goods=new GoodsDaoImpl();
		/*String name1=request.getParameter("name");
		System.out.println(name1);*/
		int tid=Integer.parseInt(request.getParameter("tid"));//获取类型id值
		System.out.println(tid);
		//商品信息
	    String goodsJson=JSON.toJSONString(goods.findGoodsByTidId(tid,1));
	    //输出
	    out.write(goodsJson.getBytes("UTF-8"));
	    out.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
