package action.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Manager;
import cn.dao.impl.ManagerDaoImpl;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("管理员登录");
		ManagerDaoImpl mg=new ManagerDaoImpl();
		String urlAccount=request.getParameter("name")==null?"":request.getParameter("name");
		String urlPwd=request.getParameter("pwd")==null?"":request.getParameter("pwd");
		Manager m=mg.findMaByNa(urlAccount);
		
		HttpSession session=request.getSession();
		

		boolean istrue=false;
		if(urlAccount!=""&&urlPwd!=null) {
			boolean isFlag=mg.FindManager(urlAccount, urlPwd, 1);
			if(isFlag) {
				istrue=true;
			}                                                                                 
		}
		if(istrue) {
			session.setAttribute("manager", m);
			request.getRequestDispatcher("ManagerPersonal.jsp").forward(request, response);
		}else {
			request.setAttribute("message","<script type='text/javascript'>alert('账户名或密码错误！！')</script>");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
