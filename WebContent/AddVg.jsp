<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加蔬菜</title>
<script type="text/javascript">
function add(){

		alert("添加成功！！！");	
}
</script>
</head>
<body>
	<form action="<%=basePath%>AddVg" method="get"  >  
        <table border="0" width="88%" align="center">  
            <tr>  
                <td>蔬菜名</td>  
                <td>  
                    <input type="text" name="name"/>  
                </td>  
            </tr>   
            <tr>  
                <td>描述</td>  
                <td>  
                    <textarea rows="3" cols="38" name="description"></textarea>  
                </td>  
            </tr>
            <tr>  
                <td>图片</td>  
                <td>  
                    <input type="file" name="img"/> 
                </td>  
            </tr>   
            <tr>  
                <td>  
                    <input type="submit" value="添加蔬菜" onclick="add()">
                </td>  
            </tr>  
        </table>  
    </form>  
     
</body>
</html>