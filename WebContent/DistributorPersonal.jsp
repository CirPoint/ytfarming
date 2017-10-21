<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	 String path = request.getContextPath();
String	basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>分销商管理</title>
		<script type="text/javascript" src="js/personal-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(function (){
				$("[id='li_menu']").click(function (){
					/*更改菜单样式*/
					$("[id='li_menu']").css("color","gray");
					$(this).css("color","red");
					$("[name='li_menu_name']").hide();
					$("."+this.className).show();
				});	
			});
			$(function (){
				$("[id='li_menu1']").click(function (){
					/*更改菜单样式*/
					$("[id='li_menu1']").css("color","gray");
					$(this).css("color","red");
					$("[name='li_menu_name1']").hide();
					$("."+this.className).show();
				});	
			});
			$(function (){
				$("[id='fuwu']").mousemove(function (){
					$("[id='fuwu']").css("color","black");
					$(this).css("color","red");
				});
			});
			//找到所有订单
			$(function (){
				$("[class='trade_all']").click(function(){
					 var url = "http://localhost:8080/ytny/DistributorInf?DisId=1";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								//alert(dates);
								$("#trade_body").html(dates);//要刷新的div
							},
							error: function() {
				               // alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			
			$(function (){
				$("[name='seeGoodType']").click(function(){
					 var url = "http://localhost:8080/MyShop1/seeGoods";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_top_ad").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//查看某一类商品信息
			$(function (){
				$("[name='SeeGoods']").click(function(){
					 var url = "http://localhost:8080/MyShop1/FindGoods?category_id=${c.id}";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_inf").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//查看耳机商品信息
			$(function (){
				$("[name='SeeFr']").click(function(){
					 var url = "http://localhost:8080/ytny/GoodsInfOfDis";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_inf").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//查看路由器商品信息
			$(function (){
				$("[name='SeeRout']").click(function(){
					 var url = "http://localhost:8080/MyShop1/FindRouter?linenum=10&index=1";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_inf").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//查看Tv商品信息
			$(function (){
				$("[name='SeeTv']").click(function(){
					 var url = "http://localhost:8080/MyShop1/FindTv?linenum=10&index=1";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_inf").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//查看Tv商品信息
			$(function (){
				$("[name='SeeTc']").click(function(){
					 var url = "http://localhost:8080/MyShop1/FindTc?linenum=10&index=1";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_inf").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加商品，选择类型
			$(function (){
				$("[name='addGoodType1']").click(function(){
					 var url = "http://localhost:8080/MyShop1/addGoods";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_top_ad1").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加Tc
			$(function (){
				$("[name='AddVg']").click(function(){
					 var url = "http://localhost:8080/ytny/AddVg.jsp";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_ad2").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加耳机
			$(function (){
				$("[name='AddEar1']").click(function(){
					 var url = "http://localhost:8080/MyShop1/AddEar.jsp";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_ad2").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加路由器
			$(function (){
				$("[name='AddRout1']").click(function(){
					 var url = "http://localhost:8080/MyShop1/AddRouter.jsp";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_ad2").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加Tv
			$(function (){
				$("[name='AddTv1']").click(function(){
					 var url = "http://localhost:8080/MyShop1/AddTv.jsp";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_ad2").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//添加商品图片
			$(function (){
				$("[name='addPt']").click(function(){
					 var url = "http://localhost:8080/MyShop1/ChooseType";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_Pt").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//删除商品图片
			$(function (){
				$("[name='delPt']").click(function(){
					 var url = "http://localhost:8080/MyShop1/DelGoodsPhoto?linenum=10&index=1";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_Pt").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			//审核用户评论
			$(function (){
				$("[class='CheckC']").click(function(){
					 var url = "http://localhost:8080/MyShop1/Conment";
					 var data = {type:1};
					 $.ajax({
							type : "get",
							async : false,  //同步请求
							url : url,
							data : data,
							timeout:1000,
							success:function(dates){
								$("#user_main_right_bottom_CheckC").html(dates);//要刷新的div
							},
							error: function() {
				               alert("失败，请稍后再试！");
				            }
						});
				 });
			});
			
			function show3(){
				location.href="http://localhost:8080/ytny/DistributorLogin.jsp";
			}
		</script>
	
	<style type="text/css">
		
		a:link,a:visited{
 		text-decoration:none;  /*超链接无下划线*/
		}
		/*a:hover{
 		text-decoration:underline;  鼠标放上去有下划线
		}*/
		
		#user_head{
			width: 1500px;
			height: 40px;
			line-height: 40px;
			list-style: none;
			background: #f5f5f5;
		}
		#user_main{
			font: 14px/1.5 "Helvetica Neue",Helvetica,Arial,"Microsoft Yahei","Hiragino Sans GB",
			"Heiti SC","WenQuanYi Micro Hei",sans-serif;
			list-style: none;
			background: #f5f5f5;
			width: 1500px;
			height: 950px;
		}
		#user_main_left{
			float: left;
			margin-left: 40px;
			background: #fff;
			width: 11%;
			height: 900px;
		}
		#user_main_right{
			float: left;
			margin-left: 20px;
			background: #fff;
			height: 800px;
			width: 1000px;
		}
		#user_main_left_ticket{
			margin-top: 10px;
			margin-left: 50px;
			float: left;
			width: 100%;
			height: 80px;
		}
		#user_main_left_ticket_head{
			
			float: left;
			width: 100%;
			height: 50px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_ticket_body{
			width: 100%;
			height: 36px;
		}
		#user_main_left_ticket_body li{
			
			float: left;
			width: 100%;
			height: 30px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_personal{
			margin-left: 50px;
			float: left;
			width: 100%;
			height: 190px;
		}
		#user_main_left_personal_hd{
			float: left;
			width: 100%;
			height: 50px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_personal_bd{
			width: 100%;
			height: 36px;
		}
		#user_main_left_personal_bd li{
			
			float: left;
			width: 100%;
			height: 30px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_shouhou{
			margin-left: 50px;
			float: left;
			width: 100%;
			height: 140px;
		}
		#user_main_left_shouhou_hd{
			float: left;
			width: 100%;
			height: 50px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_shouhou_bd{
			margin-top: 0px;
			width: 100%;
			height: 36px;
		}
		#user_main_left_shouhou_bd li{
			
			float: left;
			width: 100%;
			height: 30px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_zhanghu{
			margin-left: 50px;
			float: left;
			width: 100%;
			height: 50px;
		}
		#user_main_left_zhanghu_hd{
			float: left;
			width: 100%;
			height: 50px;
			line-height: 36px;
			text-align: left;
		}
		#user_main_left_zhanghu_bd{
			width: 100%;
			height: 36px;
		}
		#user_main_left_zhanghu_bd li{
			
			float: left;
			width: 100%;
			height: 30px;
			line-height: 36px;
			text-align: left;
		}
		
		#last{
			float: left;
			width: 1200px;
			height: 200px;
		}
		#user_main_right_top{
			width: 100%;
			height: 200px;
		}
		#user_main_right_top_left{
			/*position: absolute;*/
			margin-left: 30px;
			margin-top: 30px;
			width: 400px;
			height: 170px;
			float: left;	
		}
		#user_main_right_top_left_right{
			/*position: absolute;*/
			margin-right: 40px;
			margin-top: 50px;
			width: 100px;
			height: 30px;
			float: right;	
		}
		#user_main_right_top_right{
			/*position: absolute;*/
			margin-right: 130px;
			margin-top: 80px;
			width: 400px;
			height: 120px;
			float: right;	
		}
		#user_main_right_bottom{
			margin-top: 30px;
			margin-left: 30px;
			width: 100%;
			height: 400px;
			float: left;
		}
		#user_main_right_bottom_tleft{
			margin-top: 20px;
			margin-left: 10px;
			width: 30%;
			height: 100px;
			float: left;
		}
		#user_main_right_bottom_tleft_right{
			/*margin-right: 5px;*/
			margin-top: 25px;
			width: 160px;
			height: 50px;
			float: right;
		}
		#user_main_right_bottom_tright{
			margin-top: 20px;
			margin-right:310px ;
			width: 30%;
			height: 100px;
			float: right;
		}
		#user_main_right_bottom_tright_right{
			/*margin-right: 10px;*/
			margin-top: 25px;
			width: 160px;
			height: 50px;
			float: right;
		}
		#user_main_right_bottom_bleft{
			margin-top: 30px;
			margin-left: 10px;
			width: 30%;
			height: 100px;
			float: left;
		}
		#user_main_right_bottom_bleft_right{
			/*margin-right: 5px;*/
			margin-top: 25px;
			width: 160px;
			height: 50px;
			float: right;
		}
		#user_main_right_bottom_bright{
			margin-top: 30px;
			margin-right:310px ;
			width: 30%;
			height: 100px;
			float: right;
		}
		#user_main_right_bottom_bright_right{
			/*margin-right: 10px;*/
			margin-top: 25px;
			width: 160px;
			height: 50px;
			float: right;
		}
		#personalinf{
			width: 100%;
			height: 100%;
		}
		#trade{
			width: 100%;
			height: 100%;
		}
		#search_trade ul li
		{
			list-style: none; 
			float: left; 
			line-height: 36px;
			width: 100px;
			text-align: center;
			border-left: 1px solid #e0e0e0;
		}
		#bottom_top ul li{
			list-style: none;
			width: 200px;  
			line-height: 70px; 
			float: left; 
			font-size: 20px; 
			text-align: center;
			border-left: 1px solid #e0e0e0;
		}
		#ul_li_sha{
		list-style: none;
		width: 50px;
		height: 26px;
		line-height: 26px;
		float: left;
		
		}
	</style>
</head>
<body>
<div id="user_head">
			<a onclick="show3()">管理</a>
			<span>></span>
			<span>分销商管理员</span>
		</div>
		<div  id="user_main">
			<div id="user_main_left">
				<div id="user_main_left_ticket">
					<div id="user_main_left_ticket_head">
						<h3>个人中心</h3>
					</div>
					<div id="user_main_left_ticket_body">
						<li><a id="li_menu" class="li_menu_1" href="#personal" style="color:gray">管理个人信息</a></li>
					</div>
				</div>
				<div id="user_main_left_personal">
					<div id="user_main_left_personal_hd">
						<h3>商品管理</h3>
					</div>
					<div id="user_main_left_personal_bd">
						
							<li><a id="li_menu" class="li_menu_2" href="#goodsinf" style="color:gray" onclick="show2()">管理首页</a></li>
							<li><a id="li_menu" class="li_menu_10" href="#goodsinfor" style="color:gray" name="seeGoodType">查看商品信息</a></li>
							<li><a id="li_menu" class="li_menu_3" href="#addGoods" style="color:gray" name="addGoodType1">商品上架</a></li>
							<li><a id="li_menu" class="li_menu_5" href="#goodsPho" style="color:gray">商品配图管理</a></li>
						
					</div>
				</div>
				<div id="user_main_left_zhanghu">
					<div id="user_main_left_zhanghu_hd">
						<h3>首页管理</h3>
					</div>
					<div id="user_main_left_zhanghu_bd">
							<li><a id="li_menu" class="li_menu_9" href="#events" style="color:gray">活动公告</a></li>
							<li><a id="li_menu" class="li_menu_7" href="#changeHeadP" style="color:gray">首页轮播图管理</a></li>

					</div>
				</div>
			</div>
			<div id="user_main_right">
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：管理员
                -->
				<div id="goodsinf" name="li_menu_name" class="li_menu_2">
					<div id="user_main_right_top">
							<div class="public-nav">您当前的位置：<a href="">管理首页</a></div>
								<div class="public-content">
									<div class="public-content-header">
										<h3>网站后台</h3>
									</div>
									<div class="public-content-cont">
										<p style="width: 100%;text-align: center; padding: 50px 0; font-size: 16px; color: #FF0000;">尊敬的管理员！ 欢迎登陆网站后台！</p>
									</div>
								</div>  
							</div>
					<div id="user_main_right_bottom">
						
							<div id="user_main_right_bottom_tleft">
								<img src="img/portal-icon-1.png" />
								<div id="user_main_right_bottom_tleft_right">
									<li style="font-size: 18px;">商品：<a href="" style="color: red;">${pagebean.count}</a></li>
									<li><a href="#trade_body_n" id="li_menu" class="li_menu_1" style="color: gray;">查看商品信息</a>
									<span>></span></li>
								</div>
							</div>
							<div id="user_main_right_bottom_tright">
								<img src="img/portal-icon-2.png" />
								<div id="user_main_right_bottom_tright_right">
									<li style="font-size: 18px;">个人：<a href="" style="color: red;">0</a></li>
									<li><a href="" style="color:gray">查看个人信息</a>
									<span>></span></li>
								</div>
							</div>
							<div id="user_main_right_bottom_bleft">
								<img src="img/portal-icon-3.png" />
								<div id="user_main_right_bottom_bleft_right">
									<li style="font-size: 18px;">意见建议：<a href="" style="color: red;">${pagebean.count2}</a></li>
									<li><a href="#trade_body_n" id="li_menu" class="li_menu_8" style="color: gray;">查看待审核的建议</a>
									<span>></span></li>
								</div>
							</div>
							<div id="user_main_right_bottom_bright">
								<img src="img/portal-icon-4.png" />
								<div id="user_main_right_bottom_bright_right">
									<li style="font-size: 18px;">流量：<a href="" style="color: red;">0</a></li>
									<li><a href="#trade_body_n" id="li_menu" class="li_menu_11" style="color: gray;">查看被浏览量</a>
									<span>></span></li>
								</div>
							</div>
						
					</div>
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：商品信息
                -->
                <div id="goodsinfor" name="li_menu_name" class="li_menu_10" style="display:none;">
                	<div id="user_main_right_top_ad">
						
					</div>
					<div id="user_main_right_top_Find" height: 150px;>
                		<div id="trade_head_bd" style="height: 36px; width:100% ;" >
                			<div id="search_trade" style="width: 500px; height: 36px;float: left;">
                				<ul class="trade_style"  >
                					<li><a id="fuwu" target="_blank" style="color: black;" name="SeeVe" >查看蔬菜</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="SeeFr"  >查看水果</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="SeeTv" >查看海鲜</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="SeeRout"  >查看水产品</a></li>
                				</ul>
                			</div>
                		</div>
					</div>
					
					<div id="user_main_right_bottom_inf">
					
					</div>	
                </div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：上架商品
                -->
				<div id="addGoods" name="li_menu_name" class="li_menu_3"  style="display:none;">
					<div id="user_main_right_top_ad1">
						
					</div>
					<div id="user_main_right_top_Find" height: 150px;>
                		<div id="trade_head_bd" style="height: 100px; width:100% ;">
                			<div id="search_trade" style="width: 500px; height: 36px;float: left;">
                				<ul class="trade_style"  >
                					<li><a id="fuwu" target="_blank" style="color: black;" name="AddVg" >添加蔬菜</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="AddFr"  >添加水果</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="AddFi" >添加淡水养殖</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="AddSe"  >添加海产品</a></li>
                				</ul>
                			</div>
                		</div>
					</div>
					<div id="user_main_right_bottom_ad2">
					
					</div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：商品下架
                -->
                <div id="delGoods" name="li_menu_name" class="li_menu_4">
					<div id="user_main_right_top">
					
					</div>
					
					<div id="user_main_right_bottom">
					
					</div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：商品配图管理
                -->
                <div id="goodsPho" name="li_menu_name" class="li_menu_5" style="display: none;">
					<div id="user_main_right_top">
						<h1 class="title" style="line-height: 70px; color: gray; font-size: 30px; margin-top: 20px; margin-left: 40px; height: 120px;">
                			商品配图管理
                			<small style="font-size: 12px; margin-left: 10px; line-height: 1.5px;">
                				<a href="http://www.mi.com/service/buy/antifraud/" target="_blank" style="color: gray;">
                					管理员进行商品配图的管理，了解更多></a>
                			</small>
                		</h1>
                		<div id="trade_head_bd" style="   height: 36px; width:100% ;">
                			<div id="search_trade" style="width: 500px; height: 36px;float: left;">
                				<ul class="trade_style"  >
                					<li><a id="fuwu" target="_blank" style="color: black;" name="addPt" >添加配图</a></li>
                					<li><a id="fuwu" target="_blank" style="color: black;" name="delPt"  >删除配图</a></li>
                				</ul>
                			</div>
                		</div>
					</div>
					
					<div id="user_main_right_bottom_Pt">
					
					</div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：商品信息修改
                -->
                <div id="changeGoodsInf" name="li_menu_name" class="li_menu_6">
					<div id="user_main_right_top">
					
					</div>
					
					<div id="user_main_right_bottom">
					
					</div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：首页轮播图管理
                -->
               
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：审核评论
                -->
                <div id="checkContent" name="li_menu_name" class="li_menu_8" style="display: none;">
              		 <div id="user_main_right_top">
						<h1 class="title" style="line-height: 70px; color: gray; font-size: 30px; margin-top: 20px; margin-left: 40px; height: 120px;">
                			用户评论管理
                			<small style="font-size: 12px; margin-left: 10px; line-height: 1.5px;">
                				<a href="http://www.mi.com/service/buy/antifraud/" target="_blank" style="color: gray;">
                					管理员进行用户评论的审核，了解更多></a>
                				
                			</small>
                		</h1>
                		<div id="trade_head_bd" style="   height: 36px; width:100% ;">
                			<div id="search_trade" style="width: 500px; height: 36px;float: left;">
                				<ul class="trade_style"  >
                					<li><a href="#user_main_right_bottom_CheckC" id="li_menu1" class="CheckC" style="color: gray;" >审核评论</a></li>
                				</ul>
                			</div>
                		</div>
					 </div>
					
					 <div id="user_main_right_bottom_CheckC">
					
					 </div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：活动公告
                -->
				<div id="events" name="li_menu_name" class="li_menu_9">
              		 <div id="user_main_right_top">
					
					 </div>
					
					 <div id="user_main_right_bottom">
					
					 </div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：收益详情
                -->
                <div id="GetToatle" name="li_menu_name" class="li_menu_11">
					<div id="user_main_right_top_get">
					
					</div>
					
					<div id="user_main_right_bottom_get">
					
					</div>	
				</div>
				<!--
                	作者：offline
                	时间：2017-03-22
                	描述：订单
                -->
                <div id="personal" name="li_menu_name" class="li_menu_1" style="display: none;">
                	<div id="trade_head" style="width: 1000px; height: 200px;">
                		<h1 class="title" style="line-height: 70px; color: gray; font-size: 30px; margin-top: 20px; margin-left: 40px; height: 120px;">
                			个人
                			<small style="font-size: 12px; margin-left: 10px; line-height: 1.5px;">
                				<a href="http://www.baidu.com" target="_blank" style="color: gray;">
                					管理员进行个人信息的查看修改，了解更多></a>                                                                                             
                				
                			</small>
                		</h1>
                		<div id="trade_head_bd" style="   height: 36px; width:100% ;">
                			<div id="search_trade" style="width: 500px; height: 36px;float: left;">
                				<ul class="trade_style"  >
                					<li><a href="#trade_body_all" id="li_menu1" class="trade_all" style="color: gray;" >个人信息</a></li>
                					
                				</ul>
                			</div>
                			<div id="trade_search" style="height: 50px; width: 250px;margin-left: 10px; position: relative;float: left; margin-left: 100px;">
                					<form id="trade_s" class="search_trade" method="get"  action="<%=basePath%>FindTraById" >
                						<!--<label class="hide" for="search">站内搜索</label>-->
										<input id="nametime" class="search-text" type="search" 
										placeholder="输入用户账号（id）" autocomplete="off" name="search11" style="width: 85%; float: right; height: 35px; margin-top: 20px;">
                						<input id="asearch" class="search11" type="submit" value="搜索" style="position: absolute; right: -40px; width: 40px; height: 35px; margin-top: 20px;"/>
                					</form>
                			</div>
                		</div>
                	</div>
                	<div id="trade_body" style="width: 100%; height: 400px;">
                	
                	</div>
                </div>
                <!--
                	作者：offline
                	时间：2017-03-22
                	描述：售后服务
                -->
                <div id="shouhou" name="li_menu_name" class="li_menu_3" style="display: none;">
                	
            	</div>
            </div>
		</div>

		
${messege}
</body>

</html>