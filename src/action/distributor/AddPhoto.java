package action.distributor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddPhoto")
public class AddPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPhoto() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//上传图片
		String fileName=System.currentTimeMillis()+".jpg";
		String basePath=request.getSession().getServletContext().getRealPath("img");
		String filePath=basePath;
		System.out.println("保存图片的地址为："+filePath);
		String realFilePath=filePath+"\\"+fileName;
		//获得一个图片文件流
		BufferedImage bufferedImage=ImageIO.read(request.getInputStream());
		if(bufferedImage!=null) {
			//保存图片到指定的目录和文件中
			ImageIO.write(bufferedImage, "jpeg", new File("D:\\\\WY\\\\work\\\\ytny\\\\WebContent\\\\img",fileName));
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
