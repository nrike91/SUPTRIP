package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;
import com.suptrip.dao.jpa.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	Users user=null;
	HttpSession session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		JpaUsersDao jpaUser=new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		 user=(Users) jpaUser.getUserById(Long.parseLong(request.getParameter("id")));
		if (user!=null) {
			String passwd =request.getParameter("password");
			if (user.getPasswd().equals(passwd)) {
				session.setAttribute("user", user);
				
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
				
			}
			
		}
			
		response.sendRedirect(request.getContextPath() + "/login");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/login");
		
	}
	

}
