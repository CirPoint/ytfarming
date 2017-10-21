<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	 String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/jquery-weui.min.css" />
<link rel="stylesheet" type="text/css" href="css/weui.min.css" />
</head>
<body>

	<div style="width: 100%; height: 100px;">
		<div style="width:50%;text-align:center;float:left;">
			<a style="font-size:2rem;color:green;" name="name1" id="a1">产品大全</a> 
		</div>
		<div style="width:50%;text-align:center;float:right;">
			<a style="font-size:2rem;color:gray;" name="name1" id="a2">商家信息</a>
		</div>
	</div>
	<div id="b1">
		<div class="weui-tab">
			<div class="weui-navbar" id="type">
				<a class="weui-navbar__item weui-bar__item--on" href="#tab1-1">全部</a>
				<!-- 此处填充数据库中所有商品分类 -->	
			</div>
			<div class="weui-tab__bd" style="font-size:2rem;">
				<div id="tab1-1" class="weui-tab__bd-item weui-tab__bd-item--active">
					<div class="weui-panel weui-panel_access">
					  <div class="weui-panel__bd" id="allGoods">
					  	<!-- 此处填充扫码得到的分销商的所有商品 -->
					  </div>
					  <div class="weui-panel__ft">
					    <a onclick="nextPage()" class="weui-cell weui-cell_access weui-cell_link">
					    	<!-- 点击获取下一页信息 -->
					      
					      <div class="weui-cell__bd">查看更多</div>
					      <span class="weui-cell__ft"></span>
					    </a>    
					  </div>
					</div>
				</div>
				<div id="tab1-2" class="weui-tab__bd-item">
					<div class="weui-panel weui-panel_access">
					  <div class="weui-panel__bd" id="findGoodsByType">
					  	<!-- 此处填充分类查到的商品 -->
					  </div>
					  <div class="weui-panel__ft">
					    <a onclick="nextPage1()" class="weui-cell weui-cell_access weui-cell_link">
					    	<!-- 点击获取下一页信息 -->
					      
					      <div class="weui-cell__bd">查看更多</div>
					      <span class="weui-cell__ft"></span>
					    </a>    
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="display:none;" id="b2">
		<h1>页面二</h1>
	</div>
</body>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="js/jquery-weui.min.js" type="text/javascript"></script>
<script>
	//展示所有商品类型
	$(function(){
		$.ajax({
			type:"get",
			url:"/ytny/AllType",
			dataType:"json",
			success:function(data){
				console.log(data);
				for(var i=0;i<data.length;i++){
					$("#type").append('<a class="weui-navbar__item" href="#tab1-2" onclick="FindGoodsByType('+data[i].id+')">'+data[i].name+'</a>'
						     );
				}
			},
			error:function(data){
				console.log(data);
			}
		})
	})
	//扫码进入显示该分销商商品列表，第一页
	var page = 1;
	$(function(){
		$.ajax({
			type:"get",
			url:"/ytny/ShowAllGoods?pageindex=1",
			dataType: "json",
			success: function(data){
                console.log(data);
                for(var i=0; i<data.length; i++){
                	$("#allGoods").append('<a onclick="goodsInf(this)" href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">'+
					      '<div class="weui-media-box__hd">'+
					       ' <img class="weui-media-box__thumb" src="'+data[i].photo+'">'+
					      '</div>'+
					      '<div class="weui-media-box__bd">'+
					       ' <h4 class="weui-media-box__title">'+data[i].name+'</h4>'+
					        '<p class="weui-media-box__desc">'+data[i].time+'</p>'+
					      '</div>'+
					    '</a>');
                }
            },
            error: function(data){
            	console.log(data);
            }
		})
	});
	//查看更多商品（下一页）
	  function nextPage(){
		page += 1;
		$(function(){
			$.ajax({
				type:"get",
				url:"/ytny/ShowAllGoods?pageindex="+page,
				dataType:"json",
				success:function(data){
					console.log(data);
					for(var i=0;i<data.length;i++){
						$("#allGoods").append('<a onclick="goodsInf(this)" href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">'+
							      '<div class="weui-media-box__hd">'+
							       ' <img class="weui-media-box__thumb" src="'+data[i].photo+'">'+
							      '</div>'+
							      '<div class="weui-media-box__bd">'+
							       ' <h4 class="weui-media-box__title">'+data[i].name+'</h4>'+
							        '<p class="weui-media-box__desc">'+data[i].time+'</p>'+
							      '</div>'+
							    '</a>');
					}
				},
				error:function(data){
					console.log(data);
				}
			})
		})
	} 
	 //分类查看 
	 function FindGoodsByType(tid){
		 $(function(){
				$.ajax({
					type:"get",
					url:"/ytny/FindGoodsByType",
					data: {tid:tid},
					dataType: "json",
					success: function(data){
		                console.log(data);
		                $("#findGoodsByType").html("");
		                for(var i=0; i<data.length; i++){
		                	$("#findGoodsByType").append('<a onclick="goodsInf(this)" href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">'+
								      '<div class="weui-media-box__hd">'+
								       ' <img class="weui-media-box__thumb" src="'+data[i].photo+'">'+
								      '</div>'+
								      '<div class="weui-media-box__bd">'+
								       ' <h4 class="weui-media-box__title">'+data[i].name+'</h4>'+
								        '<p class="weui-media-box__desc">'+data[i].time+'</p>'+
								      '</div>'+
								    '</a>');
		                }
		            },
		            error: function(data){
		            	console.log(data);
		            }
				})
			}); 
	 }
	 
	
	function goodsInf(that){
		location.href="http://www.baidu.com";
		//window.open("www.baidu.com");
	}
	
	$("#a1").click(function(){
		$("#b1").show();
		$("#b2").hide();
		$("[name='name1']").css("color","gray");
		$(this).css("color","green");
	})
	$("#a2").click(function(){
		$("#b1").hide();
		$("#b2").show();
		$("[name='name1']").css("color","gray");
		$(this).css("color","green");
	})
</script>
</html>