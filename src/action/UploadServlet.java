package action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 * 文件上传Servlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UploadServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String method = request.getParameter("method");
            if (method != null) {
                if (method.equals("uploadImg")) {
                    this.uploadImg(request,response);
                }else if (method.equals("deleteImg")) {
                    this.deleteImg(request, response);
                }
            }else {//当不能从request中直接获取到数据的时候需要从流中读取
                try {
                    BufferedReader br = request.getReader();
                    String line = null;
                    StringBuffer sb = new StringBuffer();
                    while((line = br.readLine())!=null){
                        sb.append(line);
                    }
                    String params = sb.toString();
                    if(params.contains("method")){                
                        request.setAttribute("params", params);
                        if (params.contains("uploadImg")){                            
                            this.uploadImg(request,response);
                        } else if (params.contains("deleteImg")){
                            this.deleteImg(request, response);
                        } 
                        return;
                    } else {
                        response.getWriter().print("missing parameter 'method'!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        response.getWriter().close();
                    } catch (Exception e) {}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 上传图片
     * @param request
     * @param response
     */
    private void uploadImg(HttpServletRequest request,HttpServletResponse response) {
        try {
            System.out.println("=================《《图片开始上传》》===================");
            response.setContentType("text/html;charset=utf-8");
            String imgFile = request.getParameter("imgFile");
            String imgName = request.getParameter("imgName");
            
            //request中没获取到参数时的处理
            if (imgFile == null  || imgName == null ) {
                String params = (String)request.getAttribute("params");
                if (params != null && imgFile == null && params.indexOf("imgFile=") != -1){
                    imgFile = params.substring(params.indexOf("imgFile=") + "imgFile=".length(), params.indexOf("&imgName="));                   
                }else {
                    System.out.println("imgFile参数错误");
                    response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'imgFile参数错误'}").toString());
                    return;
                }
                if (params != null && imgName == null && params.indexOf("imgName=") != -1) {
                    imgName = params.substring(params.indexOf("imgName=") + "imgName=".length());
                }else {
                    System.out.println("imgName参数错误");
                    response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'imgName参数错误'}").toString());
                    return;
                }
            }
            //对参数为空进行判断
            if ("".endsWith(imgFile.trim()) || "".endsWith(imgName.trim())) {
                System.out.println("参数为空");
                response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'参数为空'}").toString());
                return;
            }
            
            imgName = URLDecoder.decode(imgName,"utf-8");//前面进行了两次编码，这里需要用解码器解码一次
            //String path = "/site/images"+File.separator+imgName;//Linux文件保存路径
            String path = "F:\\site\\images"+File.separator+imgName;//Windows文件保存路径
            
            //File file = new File("/site/images");
            File file = new File("F:\\site\\images");
            if(!file.exists() && !file.isDirectory()){//如果文件夹不存在则创建 
                System.out.println("文件目录不存在，开始创建");
                //file.mkdirs();//生成所有目录
                //file.mkdir();//生成最后一层目录
                if (!file.mkdirs()) {
                    System.out.println("文件目录创建失败");
                    response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'文件目录创建失败'}").toString());
                    return;
                }
            }
            
            FileOutputStream os = new FileOutputStream(path);
            imgFile = imgFile.replaceAll("#wb#", "+");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(imgFile);
            for(int i=0;i< b.length;++i){
                if(b[i]< 0){//调整异常数据
                    b[i]+=256;
                }
            }
            InputStream is = new ByteArrayInputStream(b);
            int len = 0;
            while((len=is.read(b))!=-1){
                os.write(b,0,len);
            }
            os.close();
            is.close();
            System.out.println("上传成功,文件保存在："+path);
            response.getWriter().print(JSONObject.fromObject("{'state':'ok','msg':'上传成功'}").toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'"+e.getMessage()+"'}").toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
    }
    /**
     * 删除图片
     * @param request
     * @param response
     */
    private void deleteImg(HttpServletRequest request,HttpServletResponse response) {
        try {
            System.out.println("=================《《图片开始删除》》===================");
            String path = request.getParameter("path");
            if (path == null || "".endsWith(path.trim())) {
                System.out.println("path参数错误");
                response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'path参数错误'}").toString());
                return;
            }
            //删除文件
            File file = new File(path);
            //路径存在并且为文件则进行删除  
            if (file.exists() && file.isFile()) {  
                file.delete();
                System.out.println("删除成功,文件路径："+path);
                response.getWriter().print(JSONObject.fromObject("{'state':'ok','msg':'删除成功'}").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().print(JSONObject.fromObject("{'state':'error','msg':'"+e.getMessage()+"'}").toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}