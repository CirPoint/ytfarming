package action.distributor;

import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.City;
import cn.bean.Distributor;
import cn.bean.Goods;
import cn.bean.Type;
import cn.dao.impl.CityDaoImpl;
import cn.dao.impl.GoodsDaoImpl;
import cn.dao.impl.TypeDaoImpl;
import cn.help.Help;
import cn.help.TwoDimension;
import cn.help.TwoDimensionCode;


@WebServlet("/AddGoodsByDis")
public class AddGoodsByDis extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private static final String UPLOAD_DIR="/img";
    
    public AddGoodsByDis() {
        super();
       
    }
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDaoImpl gd=new GoodsDaoImpl(); 
		Goods g=new Goods();
		//获取商品名，类别，描述
		int disid=Integer.parseInt(request.getParameter("distributorid"));
		
		String name=Help.txt(request.getParameter("name"));
		String description=Help.txt(request.getParameter("description"));
		int tid=Integer.parseInt(request.getParameter("tid"));
		int city=Integer.parseInt(request.getParameter("city"));
		
		/*//上传图片
		String fileName=System.currentTimeMillis()+".jpg";
		String basePath=request.getSession().getServletContext().getRealPath("img");
		String filePath=basePath;
		System.out.println("保存图片的地址为："+filePath);
		String realFilePath=filePath+"\\"+fileName;
		//获得一个图片文件流
		BufferedImage bufferedImage=ImageIO.read(request.getInputStream());
		if(bufferedImage!=null) {
			//保存图片到指定的目录和文件中
			ImageIO.write(bufferedImage, "jpeg", new File(filePath,fileName));
		}*/
		TypeDaoImpl tp=new TypeDaoImpl();
		Type t=new Type();
		t=tp.findTypeById(tid);
		
		CityDaoImpl ct=new CityDaoImpl();
		City c=new City();
		c=ct.findCityByCid(city);
		//获取分销商id
//		Distributor Dis=(Distributor)request.getSession().getAttribute("distributor");
		
		
		g.setName(name);
		//g.setPhoto(realFilePath);
		g.setTid(tid);
		g.setDescription(description);
	//	g.setDistributorid(Dis.getId());
		g.setDistributorid(disid);
		g.setCity(city);
		
		
		
		System.out.println("商品名："+g.getName()+""+"分类："+t.getName()+"地区："+c.getName()+"简介："+g.getDescription());
		TwoDimension two=new TwoDimension();
		
	
		String uuidName=UUID.randomUUID().toString()+name;
		String path=this.getServletContext().getRealPath("/img")+"\\"+uuidName+".png";
	//	String path1="D:\\WY\\work\\ytny\\WebContent\\img"+"\\"+uuidName+".png";
		g.setPhoto(path);
		System.out.println(path);
		two.QrcodeImg("商品名："+g.getName()+""+"分类："+t.getName()+"地区："+c.getName()+"简介："+g.getDescription(), path);
	/*	
		boolean f=gd.addGoods(g);
		if(f) {
			System.out.println("添加成功");
		}
		else {
			
		}
		*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
