package action.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.bean.Manager;
import cn.dao.impl.DistributorDaoImpl;
import cn.help.Help;
import cn.help.UpLog;


@WebServlet("/ChangDisInf")
public class ChangDisInfByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChangDisInfByManager() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ff=false;//标记，管理员修改信息
		//获取session
		Manager mg=(Manager)request.getSession().getAttribute("manager");
		Distributor d=new Distributor();
		//获取该分销商id
		int id=Integer.parseInt(request.getParameter("id"));
		//获取新的信息
		String newCompany=Help.txt(request.getParameter("company"));
		String newName=Help.txt(request.getParameter("name"));
		String newAddress=Help.txt(request.getParameter("address"));
		int newAreaid=Integer.parseInt(request.getParameter("areaid"));
		String newDescription=Help.txt(request.getParameter("description"));	
		String newPhone=Help.txt(request.getParameter("phone"));
		//加入	
		d.setCompany(newCompany);
		d.setName(newName);
		d.setAddress(newAddress);
		d.setInformation(newDescription);
		d.setAreaid(newAreaid);
		d.setPhone(newPhone);
		
		DistributorDaoImpl dis=new DistributorDaoImpl();
		boolean f=dis.changInf(d,id);
		if(f) {
			//生成日志
			UpLog.Uplog("修改分销商"+dis.findDisById(id).getName()+"的信息",mg.getName());
			System.out.println("修改成功");
			request.getRequestDispatcher("AllDistributor").forward(request, response);
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
