package action.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Manager;
import cn.dao.impl.ManagerDaoImpl;
import cn.help.Help;
import cn.help.UpLog;


@WebServlet("/ChangePwdOfSelf")
public class ChangePwdOfSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChangePwdOfSelf() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("超级管理员修改自己登陆密码");
		boolean ff=false;//标记
		Manager manager=(Manager) request.getSession().getAttribute("manager");
		
		String managerPwd=Help.txt(request.getParameter("managerpwd"));
		String newPassword=Help.txt(request.getParameter("password"));
		String newPassword2=Help.txt(request.getParameter("password2"));
		
		if(managerPwd.equals(manager.getManagerpwd())) {
			if(newPassword.equals(newPassword2)) {
				ManagerDaoImpl m=new ManagerDaoImpl();
				boolean f=m.changPwd(manager.getId(), newPassword2);
				if(f) {
					UpLog.Uplog("修改超级管理员密码", manager.getName());
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					System.out.println("修改成功,请重新登陆！");
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
