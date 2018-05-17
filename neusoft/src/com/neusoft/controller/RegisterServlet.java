package com.neusoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.edu.pojo.SNSUserInfo;
import com.neusoft.model.bean.UserInfo;
import com.neusoft.model.service.UserService;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SNSUserInfo snsUserInfo = (SNSUserInfo)request.getSession().getAttribute("snsUserInfo");
		try {
			String username = request.getParameter("username");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("telephone");
			String workplace = request.getParameter("workplace");
			String email = request.getParameter("email");
			String[] agendar = request.getParameterValues("agendar");
			String agendarstr = "";
			for(String str: agendar)
			{
				agendarstr+=str;
			}
			
			UserInfo user = new UserInfo();
			user.setUsername(username);
			user.setSex(sex);
			user.setUsertele(telephone);
			user.setUserwork(workplace);
			user.setUseremail(email);
			int QRcode = (int) Math.floor(Math.random()*10000000);
			Boolean flag = false;
			flag = UserService.getUserInstanceof().selectQRcode(QRcode);
			while(flag){
				QRcode = (int) Math.floor(Math.random()*10000000);
				flag = UserService.getUserInstanceof().selectQRcode(QRcode);
			}
			user.setUserQRcode(QRcode);
			user.setAgendar(agendarstr);
			user.setOpenid(snsUserInfo.getOpenId());
			user.setImgurl(snsUserInfo.getHeadImgUrl());
			UserService.getUserInstanceof().insertUser(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		UserInfo u = null;
		try {
			u = UserService.getUserInstanceof().getUserinfo(snsUserInfo.getOpenId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("u", u);
		
		response.sendRedirect("E-ticket.jsp");
		
	}

}
