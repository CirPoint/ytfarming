package action.distributor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.util.IOUtils;

@WebServlet("/AddGoodsByDisTest")
public class AddGoodsByDisTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddGoodsByDisTest() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map=new HashMap<String,String>();
		//创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(1024*100);
		factory.setRepository(new File(this.getServletContext().getRealPath("/WEB-INF/tmp")));
		//使用DiskFileItemFactory对象创建ServletFileUpload对象，并设置上传文件的大小限制
		ServletFileUpload fileUpload=new ServletFileUpload();
		//检查是否是正确的文件上传表单
		if(!fileUpload.isMultipartContent(request)) {
			throw new RuntimeException("请上传正确的表单");
		}
		//设置单个文件上传大小：
		fileUpload.setFileSizeMax(1024*10204*5);
		//设置文件上传的总大小
		fileUpload.setSizeMax(1024*10204*200);
		//对上传内容进行解析
		try {
			List<FileItem> list=fileUpload.parseRequest((RequestContext) request);
			//遍历上传的文件内容
			for(FileItem item:list) {
				//如果上传的是表单内容，即不带文件的内容
				if(item.isFormField()) {
					//将表单中获得的名称获取
					String name=item.getFieldName();
					//获取内容，编码方式为utf-8
					String value=item.getString("utf-8");
					//将名称和值放入map
					map.put(name, value);
				}else {
					//是否是带有文件的内容
					String name=item.getName();
					//创建随机名称，这样能使上传的商品图片名称唯一
					String uuidName=UUID.randomUUID().toString()+name;
					//创建文件保存的物理路径
					String path=this.getServletContext().getRealPath("/WEB-INF/upload");
					//获取文件的hash值
					int hashCode=uuidName.hashCode();
					//将文件的hash值转化为16进制字符串
					String hashStr=Integer.toHexString(hashCode);
					//将获取的hashStr转换成数组
					char hss[]=hashStr.toCharArray();
					//初始化图片上传的目录是upload文件夹下
					String imgurl="/WEB-INF/upload";
					//为了使图片上传的文件夹保存图片均衡，遍历
					for(char c:hss) {
						path+="/"+c;
						imgurl+="/"+c;
					}
					imgurl+="/"+uuidName;
					//将图片url放在map中
					map.put("imgurl", imgurl);
					//创建文件夹
					new File(path).mkdirs();
					System.out.println("查看地址"+path);
					//文件的读写
					InputStream in=item.getInputStream();
					OutputStream out=new FileOutputStream(new File(path, uuidName));
				//	IOUtils.In2Out(in,out);
				//	IOUtils.close(in,out);
					//删除临时文件
					item.delete();
				//	PicUtils picUtils=new PicUtils(path+"/"+uuidName);
				//	picUtils.resizeByHeight(100);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
