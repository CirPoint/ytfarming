package action.distributor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.dao.impl.DistributorDaoImpl;
import cn.help.Help;


@WebServlet("/ChangDisInfByDis")
public class ChangDisInfByDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChangDisInfByDis() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ff=false;//标记，分销商修改自己信息
		//获取session
		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		Distributor d=new Distributor();
		
		
		String newCompany=Help.txt(request.getParameter("company"));
		String newName=Help.txt(request.getParameter("name"));
		String newAddress=Help.txt(request.getParameter("address"));
		int newAreaid=Integer.parseInt(request.getParameter("areaid"));
		String newDescription=Help.txt(request.getParameter("description"));	
		String newPhone=Help.txt(request.getParameter("phone"));
			
		d.setCompany(newCompany);
		d.setName(newName);
		d.setAddress(newAddress);
		d.setInformation(newDescription);
		d.setAreaid(newAreaid);
		d.setPhone(newPhone);
		
		DistributorDaoImpl dis=new DistributorDaoImpl();
		boolean f=dis.changInf(d,Dis.getId());
		if(f) {
			System.out.println("修改成功");
			request.getRequestDispatcher("DistributorInf").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
