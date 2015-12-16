package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaUsersDao jpaUser=new  JpaUsersDao(PersistanceManager.getEntityManagerFactory()) ;
		JpaCampusDao jpaCampus= new JpaCampusDao(PersistanceManager.getEntityManagerFactory());

		HttpSession session=request.getSession();
		
		Users user=(Users) session.getAttribute("user");
		
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setPasswd(request.getParameter("password"));
		user.setEmailAdress(request.getParameter("email"));
		user.setIdCampus(jpaCampus.getCampusById( Long.parseLong(request.getParameter("Campus"))));
		
		
		jpaUser.updateUser(user);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		
	}

	
	

	
}
