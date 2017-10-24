package action.manager;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;


import cn.dao.impl.LogDaoImpl;
import cn.help.Page;


@WebServlet("/ShowAllLog")
public class ShowAllLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowAllLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean f=false;
		System.out.println("查看所有日志");
		
	//	int linenum=Integer.parseInt(request.getParameter("linenum"));
	//	int pageIndex=Integer.parseInt(request.getParameter("10"));
	
		
		
		
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
        LogDaoImpl log=new LogDaoImpl();
        
        Page pg=new Page();
		pg.setCount(log.findCountLog());
		pg.setSize(10);
		pg.setPageSize(0);
		pg.setPageIndex(1);
		pg.setListLog(log.findLogInfoWithLine(1));
		String logJson=JSON.toJSONString(pg.getListLog());
		OutputStream out = response.getOutputStream();  
        out.write(logJson.getBytes("UTF-8"));  
        out.flush();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
