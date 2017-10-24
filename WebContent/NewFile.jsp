<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加文件</title>
<script type="text/javascript">
function add(){

		alert("添加成功！！！");	
}
</script>
</head>
<body>
	<form action="<%=basePath%>AddArticle" enctype="multipart/form-data" method="post"  >  
        <table border="0" width="88%" align="center">  
            <tr>  
                <td>商品名</td>  
                <td>  
                    <input type="text" name="name"/>  
                </td>  
            </tr> 
            <tr>  
                <td>商家</td>  
                <td>  
                    <input type="text" name="distributorid"/>  
                </td>  
            </tr>
            <tr>  
                <td>种类</td>  
                <td>  
                    <input type="text" name="tid"/>  
                </td>  
            </tr> 
            <tr>  
                <td>地区</td>  
                <td>  
                    <input type="text" name="city"/>  
                </td>  
            </tr> 
            <tr>  
                <td>文件：</td>  
                <td>  
                    <input type="file" name="img"/> 
                </td>  
            </tr>   
            <tr>  
                <td>  
                    <input type="submit" value="添加商品" onclick="add()">
                </td>  
            </tr>  
        </table>  
    </form> 
    ${message}     
</body>

</html>