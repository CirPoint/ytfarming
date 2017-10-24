<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%	 String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/login.css" />
<title>管理员登录</title>
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">管理员登陆</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post" onsubmit="" action="<%=basePath%>LoginAction">
				<ul>
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" name="name" class="login_input">
				</li> 
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" name="pwd" class="login_input">
				</li>
				<li class="login-sub">
					<input type="submit" name="Submit" value="管理员登录" />
				</li>
				</ul>                     
           </form>
		</div>
	</div>
</div>
${message}
</body>
</html>