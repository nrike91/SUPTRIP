package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Users;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user=new Users();
		JpaCampusDao jpaCampus=(JpaCampusDao) request.getAttribute("jpacampus");
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPasswd(request.getParameter("password"));
		user.setEmailAdress(request.getParameter("email"));
		user.setIdCampus(jpaCampus.getCampusById( Long.parseLong(request.getParameter("Campus"))));
		
		
		JpaUsersDao jpaUser=(JpaUsersDao) request.getAttribute("jpauser");
		jpaUser.updateUser(user);
		getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
}
