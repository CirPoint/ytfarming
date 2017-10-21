package action.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Distributor;
import cn.dao.impl.DistributorDaoImpl;
import cn.help.Page;


@WebServlet("/SearchDis")
public class SearchDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchDis() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("条件查询分销商");
		//int Aid=Integer.parseInt(request.getParameter("id"));
		String disJson=null;
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
        OutputStream out = response.getOutputStream();  
        
		DistributorDaoImpl dis=new DistributorDaoImpl();
		Page p=new Page();
		//获取条件
		String condition=request.getParameter("");
		//获取查询字段
		String letter=request.getParameter("");
		//获取页码
		int pageIndex=Integer.parseInt(request.getParameter("index"));
		if(condition.equals("账号")) {
			
			 p.setCount(dis.findCountLog());
			 p.setSize(10);
		     p.setPageSize(0);
		     p.setListDis(dis.findDisByIdentity(letter, pageIndex));
		     p.setPageIndex(pageIndex);
			 disJson=JSON.toJSONString(p.getListDis());
			 	
		}else if(condition.equals("商家名")) {
			p.setCount(dis.findCountLog());
			 p.setSize(10);
		     p.setPageSize(0);
		     p.setListDis(dis.findDisByCompany(letter, pageIndex));
		     p.setPageIndex(pageIndex);
			 disJson=JSON.toJSONString(p.getListDis());
			 
		}else if(condition.equals("联系人")) {
			 p.setCount(dis.findCountLog());
			 p.setSize(10);
		     p.setPageSize(0);
		     p.setListDis(dis.findDisByName(letter, pageIndex));
		     p.setPageIndex(pageIndex);
			 disJson=JSON.toJSONString(p.getListDis());
			
		}else if(condition.equals("地址")) {
			 p.setCount(dis.findCountLog());
			 p.setSize(10);
		     p.setPageSize(0);
		     p.setListDis(dis.findDisByAddress(letter, pageIndex));
		     p.setPageIndex(pageIndex);
			 disJson=JSON.toJSONString(p.getListDis());

		}else if(condition.equals("备注")) {
		//	String disJson=JSON.toJSONString(dis.findDisByIdentity(letter));
			
		}
		out.write(disJson.getBytes("UTF-8"));  
        out.flush();
		
		/*List<Distributor> d=dis.findDisByAreaID(Aid);
		request.setAttribute("distributor", d);
		request.getRequestDispatcher("").forward(request,response);*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
