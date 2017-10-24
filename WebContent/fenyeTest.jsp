<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	 String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
<script type="text/javascript">
	function nextpage(istrue){
		if(istrue){
			location.href="http://localhost:8080/ytny/ShowAllLog?index="+${pagebean.pageIndex+1};
		}else{
			alert("当前已经是尾页!");
		}
	}
	function uppage(istrue){
		if(istrue){
			location.href="http://localhost:8080/ytny/ShowAllLog?index="+${pagebean.pageIndex-1};
		}
		else{
			alert("当前已经是首页!");
		}
	}
	 function show()
	    {
	    	location.href="http://localhost:8080/ytny/ShowAllLog?linenum=10&index=1";
	    }
	 function show1()
	    {
	    	alert("删除成功！！！！！");
	    }
</script>
</head>
<body >
	<a onclick="show()">日志</a>
 	<table border="1" width="88%" style="text-align:center" align="center" >  
            <tr>  
                <th>时间</th>  
                <th>事件</th>  
                <th>操作者</th>  
                <th>ip</th>  
            </tr> 
            <c:forEach items="${pagebean.listLog}" var="o">  
                <tr>  
                    <td>${o.time}</td>  
                    <td>${o.record}</td>  
                    <td>${o.operator }</td> 
                    <td>${o.ip}</td>
                    
                    <td>  
                        <a href="<%=basePath%>DelDis?LogId=${o.id}"  onclick="show1()">删除</a>  
                    </td>  
                </tr>  
                <input id="cccis" value="${o.id}" style="display:none"/> 
            </c:forEach>  
        </table>  
	<p>第${pagebean.pageIndex}/${pagebean.pageSize}页;共${pagebean.count}条记录 </p>
	<p>
		<input type="button" value="上一页" onclick="uppage(${pagebean.hasUpPage})"/>
		<input type="button" value="下一页" onclick="nextpage(${pagebean.hasNextPage})"/>
	</p>
</body>
</html>