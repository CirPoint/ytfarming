package action.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.dao.impl.LogDaoImpl;
import cn.help.UpLog;


@WebServlet("/DelLog")
public class DelLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelLog() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ff=false;//标记
		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		int id=Integer.parseInt(request.getParameter("id"));
		LogDaoImpl log=new LogDaoImpl();
		if(Dis!=null) {
			log.DeletLog(id);
			UpLog.Uplog("删除日志",Dis.getName());
			request.getRequestDispatcher("ShowAllGoods").forward(request, response);
		}else {
			request.getRequestDispatcher("ShowAllGoods").forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
