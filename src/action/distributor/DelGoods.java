package action.distributor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.dao.impl.GoodsDaoImpl;
import cn.help.UpLog;


@WebServlet("/DelGoods")
public class DelGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DelGoods() {
        super();
    }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		boolean ff=false;//标记
		GoodsDaoImpl gd=new GoodsDaoImpl();
		
		int gid=Integer.parseInt(request.getParameter("id"));
		
		boolean f=gd.deleteGoods(gid);
		if(f) {
			Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
			UpLog.Uplog("删除商品",Dis.getName());
		}
		request.getRequestDispatcher("ShowAllGoods").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
