<%@page import="com.neusoft.model.bean.UserInfo"%>
<%@page import="com.neusoft.model.service.UserService"%>
<%@page import="com.neu.edu.pojo.SNSUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" charset="utf-8" />
		<title>我要报名</title>
		<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/apply.js" ></script>
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/apply.css" />
		<style>
			@media only screen and (min-width: 640px) {
				
				body
				{
					width: 640px;
					margin: 0 auto;
				}
				
				#bottom
				{
					width: 640px;
				}
				
			}
		</style>
	</head>
	<body>
	<%
	SNSUserInfo snsUserInfo = (SNSUserInfo)request.getSession().getAttribute("snsUserInfo"); 
	UserService service = UserService.getUserInstanceof();
	UserInfo u = service.getUserinfo(snsUserInfo.getOpenId());
	session.setAttribute("u",u);
	
	if(request.getParameter("action")==null && u!=null)
	{
		response.sendRedirect("E-ticket.jsp");
	} 
	%>
	<form action="registerServlet" method="post" >
		<div id="top">参会人信息 ( 报名时间:即日起——2018年6月12日 )</div>
		<div id="middle">
			<div class="m_child">
				<p><font color="#78cbf1">*</font> 姓名:</p>
				<input type="text" id="username" name="username" autocomplete="off" value="${u.username}" />
			</div>
			
				<!-- <p><font color="#78cbf1">*</font> 性别:</p>
				<span id="select">请选择</span><i class="fa fa-chevron-down" aria-hidden="true"></i>
				<ul>
					<li>男</li>
					<li>女</li>
				</ul> -->
				<div style="padding:10px;font-size: 15px;font-family:黑体;margin-left:15px;color:#989898">
				
				<input type="radio" name="sex" value="男" ${u==null?"checked":""} ${u.sex=="男"?"checked":""} />男
				&nbsp;&nbsp;
				<input type="radio" name="sex" value="女" ${u.sex=="女"?"checked":""} />女
			    </div>
			<div class="m_child">
				<p><font color="#78cbf1">*</font> 手机:</p>
				<input type="text" id="telephone" name="telephone" autocomplete="off" value="${u.usertele}"/>
			</div>
			<div class="m_child">
				<p><font color="#78cbf1">*</font> 单位:</p>
				<input type="text" id="workplace" name="workplace" autocomplete="off" value="${u.userwork}"/>
			</div>
			<div class="m_child">
				<p><font color="#78cbf1">*</font> 邮箱:</p>
				<input type="email" id="email" name="email" autocomplete="off" value="${u.useremail}"/>
			</div>
			<div class="m_child">
				<p><font color="#78cbf1">*</font> 参会日程:</p>
				<div id="content">
				   <%
				      if(u==null)
				      {
				    	  %>
				    	   <input type="checkbox" name="agendar" value="A" checked/> 6月13日主论坛<br />
					新工科产业学院交流会暨人才培养高峰论坛 <br />
					<input type="checkbox" name="agendar" value="B" checked/> 6月13日分论坛<br />
					产业学院合作模式探讨<br />
					<input type="checkbox" name="agendar" value="C" checked/> 晚宴<br />
					
				    	  <% 
				      }
				   %>
					
					
					 <%
					 			   
					 if(u!=null && u.getAgendar().indexOf("A")>=0)
				       {
				    	   %>
				    	    <input type="checkbox" name="agendar" value="A" checked/> 6月13日主论坛<br />
					新工科产业学院交流会暨人才培养高峰论坛 <br />
				    	   <% 
				       }
				       else if(u!=null && u.getAgendar().indexOf("A")<0)
				       {
				    	   %>
				    	   <input type="checkbox" name="agendar" value="A"/> 6月13日主论坛<br />
					新工科产业学院交流会暨人才培养高峰论坛 <br />
				    	   <%  
				       }
				    %>
				    
				    <%
				       if(u!=null && u.getAgendar().indexOf("B")>=0)
				       {
				    	   %>
				    	    <input type="checkbox" name="agendar" value="B" checked/> 6月13日分论坛<br />
					产业学院合作模式探讨<br />
				    	   <% 
				       }
				       else if(u!=null && u.getAgendar().indexOf("B")<0)
				       {
				    	   %>
				    	   <input type="checkbox" name="agendar" value="B"/> 6月13日分论坛<br />
					产业学院合作模式探讨<br />
				    	   <%  
				       }
				    %>
				    
				    <%
					 			   
					 if(u!=null && u.getAgendar().indexOf("C")>=0)
				       {
				    	   %>
				    	    <input type="checkbox" name="agendar" value="C" checked/> 晚宴<br />
					
				    	   <% 
				       }
				       else if(u!=null && u.getAgendar().indexOf("C")<0)
				       {
				    	   %>
				    	   <input type="checkbox" name="agendar" value="C"/> 晚宴<br />
					
				    	   <%  
				       }
				    %>
					
				</div>
			</div>
			<input type="hidden" name="sex" />
		</div>
		<div id="bottom">保存</div>
	</form>
	</body>
</html>
