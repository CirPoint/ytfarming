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

@WebServlet("/ChangePwdOfDis")
public class ChangePwdOfDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChangePwdOfDis() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("管理员修改分销商登陆密码");
		boolean ff=false;//标记
		Manager manager=(Manager) request.getSession().getAttribute("manager");
		DistributorDaoImpl d=new DistributorDaoImpl();
		//获取所找分销商的id，得到该分销商
		int id=Integer.parseInt(request.getParameter("id"));
		Distributor dis=d.findDisById(id);
		//获取原密码，新密码的值
		String disPwd=Help.txt(request.getParameter("password"));
		String newPassword=Help.txt(request.getParameter("password1"));
		String newPassword2=Help.txt(request.getParameter("password2"));
		
		if(disPwd.equals(dis.getPassword())) {
			if(newPassword.equals(newPassword2)) {
				boolean f=d.UpdatPassword(dis.getId(), newPassword2);
				if(f) {
					UpLog.Uplog("修改分销商密码", manager.getName());
					request.getRequestDispatcher("").forward(request, response);
					System.out.println("修改成功！");
				}
			}else {
				System.out.println("新密码不一致，请重新确认！");
			}
		}else {
			System.out.println("管理密码有误，请重新输入！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
