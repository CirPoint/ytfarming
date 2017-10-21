package action.user;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.dao.impl.TypeDaoImpl;

@WebServlet("/AllType")
public class AllType extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AllType() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("所有类型");
		boolean ff=false;//标记
		OutputStream out = response.getOutputStream();  
		//json乱码处理
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
        //类型
        TypeDaoImpl type= new TypeDaoImpl();
        String typeJson=JSON.toJSONString(type.findAllType());
        out.write(typeJson.getBytes("UTF-8"));  
        out.flush(); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
