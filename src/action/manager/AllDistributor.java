package action.manager;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.dao.impl.DistributorDaoImpl;


@WebServlet("/AllDistributor")
public class AllDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AllDistributor() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getSession().getServletContext().getRealPath("");
		System.out.println(a);
		/*	System.out.println("所有分销商");
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
		
		DistributorDaoImpl dis=new DistributorDaoImpl();
		String userJson=JSON.toJSONString(dis.findAllDis());
		OutputStream out = response.getOutputStream();  
        out.write(userJson.getBytes("UTF-8"));  
        out.flush();  */
       // System.out.println(2222222);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
