package action.distributor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Distributor;
import cn.bean.Manager;
import cn.dao.impl.DistributorDaoImpl;
import cn.dao.impl.ManagerDaoImpl;
import cn.help.Help;
import cn.help.UpLog;

@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChangePwd() {
        super();
       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("分销商修改自己登陆密码");
		boolean ff=false;//标记
		//获取session
		Distributor dis=(Distributor) request.getSession().getAttribute("distributor");
		//获取原密码，新密码的值
		String disPwd=Help.txt(request.getParameter("password"));
		String newPassword=Help.txt(request.getParameter("password1"));
		String newPassword2=Help.txt(request.getParameter("password2"));
		//修改
		if(disPwd.equals(dis.getPassword())) {
			if(newPassword.equals(newPassword2)) {
				DistributorDaoImpl d=new DistributorDaoImpl();
				boolean f=d.UpdatPassword(dis.getId(), newPassword2);
				if(f) {
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
