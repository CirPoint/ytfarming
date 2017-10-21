package action.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.dao.impl.DistributorDaoImpl;
import cn.help.Help;
import cn.help.UpLog;


@WebServlet("/AddDis")
public class AddDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddDis() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加分销商");
		boolean bb=false;//标记
		DistributorDaoImpl dis=new DistributorDaoImpl();
		Distributor d=new Distributor();
		boolean b=true;
		//获取数据
		String identity=Help.txt(request.getParameter("identity"));
		String information=Help.txt(request.getParameter("information"));
		String company=Help.txt(request.getParameter("company"));
		String address=Help.txt(request.getParameter("address"));
		String name=Help.txt(request.getParameter("name"));
		String password=Help.txt(request.getParameter("password"));
		String phone=Help.txt(request.getParameter("phone"));
		int  areaid=Integer.parseInt(request.getParameter("areaid"));
		//判断账号是否存在
		List<Distributor> di=dis.findAllDis();
		for(Distributor dd:di) {
			if(identity.equals(dd.getIdentity())) {
				b=false;
			}
		}
		//添加账号
		if(b) {
				d.setName(name);
				d.setAddress(address);
				d.setCompany(company);
				d.setInformation(information);
				d.setPhone(phone);
				d.setLevelid(2);
				d.setIdentity(identity);
				d.setPassword(password);
				d.setAreaid(areaid);
				
				dis.addDistributor(d);
				//加入日志
				Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
				UpLog.Uplog("添加分销商",Dis.getName());
				//返回
				request.getRequestDispatcher("").forward(request, response);
		}else {
			System.out.println("添加失败");
		}
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
