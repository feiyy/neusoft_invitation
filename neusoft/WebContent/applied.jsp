<%@page import="com.neusoft.model.bean.UserInfo"%>
<%@page import="com.neusoft.model.service.UserService"%>
<%@page import="com.neu.edu.pojo.SNSUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" charset="utf-8" />
		<title>已报名</title>
		<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/applied.css"/>
		<script type="text/javascript" src="js/applied.js" ></script>
		<style>
			@media only screen and (min-width: 640px) {
				
				body
				{
					width: 640px;
					margin: 0 auto;
				}
		
			}
		</style>
	</head>
	<%
	SNSUserInfo snsUserInfo = (SNSUserInfo)request.getSession().getAttribute("snsUserInfo"); 
	UserService service = UserService.getUserInstanceof();
	UserInfo u = service.getUserinfo(snsUserInfo.getOpenId());
	session.setAttribute("u",u);
	if(u==null)
	{
		response.sendRedirect("apply.jsp");
	} 	
	%>
	<body>
		<div id="top">
			个人中心
				
		</div>
		<div id="middle">
			<!-- <div id="user">
			<i class="fa fa-user-circle" aria-hidden="true"></i>
			</div> -->
			<div style="text-align:center;padding-top:10px">
			    <img style="width:100px;height:100px;border-radius:50px" src="${u.imgurl}"/>
			</div>
			<p id="username">${u.username}</p>
			<p id="workplace">${u.userwork}</p>
		</div>
		<div id="bottom">
			<p style="height:50px;line-height:50px;color:#8f8f8f">我的参会信息</p>
			<ul id="message">
				<li>我的报名表<i class="fa fa-chevron-right" aria-hidden="true"></i></li>
				<li>修改个人信息<i class="fa fa-chevron-right" aria-hidden="true"></i></li>
				<li>我的电子票<i class="fa fa-chevron-right" aria-hidden="true"></i></li>
			</ul>
			<div id="loginout">退出登录</div>
		</div>
	</body>
</html>
