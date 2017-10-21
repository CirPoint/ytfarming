package action.distributor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Distributor;
import cn.dao.impl.DistributorDaoImpl;



@WebServlet("/DisLogin")
public class DisLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DisLogin() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("分销商登录");
		DistributorDaoImpl mg=new DistributorDaoImpl();
		String urlAccount=request.getParameter("name1")==null?"":request.getParameter("name1");
		String urlPwd=request.getParameter("pwd1")==null?"":request.getParameter("pwd1");
		
		HttpSession session=request.getSession();
		
		Distributor dis=mg.findDisByIden(urlAccount);
		
		session.setAttribute("distributor", dis);
		boolean istrue=false;
		if(urlAccount!=""&&urlPwd!=null) {
			boolean isFlag=mg.finDis(urlAccount, urlPwd);	
			if(isFlag/*&&(dis.getId()==2)*/) {
				istrue=true;
			}
		}
		if(istrue) {
			//管理员存入session对象中
			request.getSession().setAttribute("username", urlAccount);
			request.getSession().setAttribute("password", urlPwd);
			System.out.println("分销商管理");
			request.getRequestDispatcher("DistributorPersonal.jsp").forward(request, response);
		}else {
			request.setAttribute("messege","<script type='text/javascript'>alert('账户名密码错误,或权限不足')</script>");
			request.getRequestDispatcher("DistributorLogin.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
