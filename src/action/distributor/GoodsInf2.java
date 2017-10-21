package action.distributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.bean.Goods;
import cn.dao.impl.GoodsDaoImpl;
import cn.help.UpLog;


@WebServlet("/GoodsInf2")
public class GoodsInf2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GoodsInf2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("分销商查看自己的某类商品信息");
		//从session中获取分销商
		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		
		UpLog.Uplog("查看自己商品",Dis.getName());
		
		GoodsDaoImpl g=new  GoodsDaoImpl();
		int tid=Integer.parseInt(request.getParameter("tid"));
		PrintWriter out=response.getWriter();
		System.out.println(tid);
		List<Goods> gd=g.findGoodsByTidId(tid, Dis.getId());
		for(Goods gg:gd) {
			System.out.println(gg.getName()+","+gg.getDescription());
		}
		request.setAttribute("allgoods", gd);
		out.flush();
		out.close();
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
