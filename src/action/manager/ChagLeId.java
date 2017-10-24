package action.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.impl.DistributorDaoImpl;


@WebServlet("/ChagLeId")
public class ChagLeId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChagLeId() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("管理员降低分销商权限");
		
		int did=Integer.parseInt(request.getParameter("distributorId"));
		
		DistributorDaoImpl dis=new DistributorDaoImpl();
		boolean f=dis.changeLvId(did, 3);
		if(f) {
			
		}
		else {
			
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
