<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%	String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
<script type="text/javascript">

</script>
</head>
<body>
	  <c:forEach items="${goodsinf}" var="o" >
	  	 <c:forEach items="${type}" var="t"> 
	  	 <table border="0" width="50%" align="center">  
        	<tr>  
                <td>商品编号:</td>  
                <td>  
                   ${o.id}
                </td>  
            </tr> 
            <tr>  
                <td>类型:</td>  
                <td>  
                    ${t.name}
                </td>  
            </tr>
            <tr>  
                <td>商品名:</td>  
                <td> 
                    ${o.name}
                </td>  
            </tr>   
            <tr>  
                <td>描述:</td>  
                <td>  
                    ${o.description}
                </td>  
            </tr>
           <!--  <tr>  
                <td>分销商</td>  
                <td>  
                    
                </td>  
            </tr>
            <tr>  
                <td>图片</td>  
                <td>  
                     
                </td>  
            </tr>     -->
         </table> 
	  	 </c:forEach>
      </c:forEach>    
</body>
</html>