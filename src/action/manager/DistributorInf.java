package action.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.bean.Area;
import cn.bean.Distributor;
import cn.dao.impl.AreaDaoImpl;
import cn.dao.impl.DistributorDaoImpl;


@WebServlet("/DistributorInf")
public class DistributorInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DistributorInf() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("分销商信息");
		
		int DistributorId=Integer.parseInt(request.getParameter("DisId"));
		response.setContentType("application/json; charset=utf-8");  
        response.setCharacterEncoding("UTF-8"); 
		//分销商信息
		DistributorDaoImpl dis=new DistributorDaoImpl();
		String userJson=JSON.toJSONString(dis.findDisById(DistributorId));
		OutputStream out = response.getOutputStream();  
		//所在地区信息
		AreaDaoImpl area=new AreaDaoImpl();
		String areaJson=JSON.toJSONString(area.findAreaById(dis.findDisById(DistributorId).getAreaid()));
		
		
        out.write(userJson.getBytes("UTF-8"));
        out.write(areaJson.getBytes("UTF-8"));
        
        out.flush();  
		
		
		/*int DistributorId=Integer.parseInt(request.getParameter("DisId"));
		//获取分销商信息
		Distributor d=new DistributorDaoImpl().findDisById(DistributorId);
		List<Object> list=new ArrayList<Object>();
		list.add(d);
		//获取该分销商所在区id，找到其对应的名称
		AreaDaoImpl A=new AreaDaoImpl();
		Area listA=A.findAreaById(d.getAreaid());
		List<Object> list1=new ArrayList<Object>();
		list1.add(listA);
		
		//传值
		request.setAttribute("distributor", list);
		request.setAttribute("listA", list1);
		request.getRequestDispatcher("DistributorInf.jsp").forward(request, response);*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
