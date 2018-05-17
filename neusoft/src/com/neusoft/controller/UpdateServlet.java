package com.neusoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.model.bean.UserInfo;
import com.neusoft.model.service.UserService;

public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo u = (UserInfo)request.getSession().getAttribute("u");
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
			
			u.setUsername(username);
			u.setSex(sex);
			u.setUsertele(telephone);
			u.setUserwork(workplace);
			u.setUseremail(email);
			u.setAgendar(agendarstr);
			UserService.getUserInstanceof().updateUser(u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("applied.jsp");
		
	}

}
