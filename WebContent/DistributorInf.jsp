<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%	String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分销商信息</title>
<script type="text/javascript">

</script>
</head>
<body>
	<center>
		 <c:forEach items="${distributor}" var="o" >
		 	
	  	<%--  <c:forEach items="${type}" var="t">  --%>
	  	 <table border="0" width="50%" align="center">  
        	
        	<tr>
        		<td>公司名：</td>
        		<td>${o.company}</td>
        	</tr>
            <tr>  
                <td>分销商名:</td>  
                <td> 
                    ${o.name}
                </td>  
            </tr> 
            <tr>  
                <td>地址:</td>  
                <td> 
                    ${o.address}
                </td>  
            </tr>   
             <tr>  
                <td>联系方式:</td>  
                <td>  
                    ${o.phone}
                </td>  
            </tr>
            <tr>
	            <td>地区:</td>	
            	 <c:forEach items="${listA}" var="lista">
	            	<td>${lista.name}</td>   
	             </c:forEach>
      		 </tr>
      		 <tr>  
                <td>简介:</td>  
                <td>  
                    ${o.information}
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
	  	<%--  </c:forEach> --%>
	  	
      </c:forEach>
      
	</center>    
</body>
</html>