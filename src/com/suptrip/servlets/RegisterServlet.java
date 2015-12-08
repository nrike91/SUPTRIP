package com.suptrip.servlets;

import java.io.IOException;

import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ejb.packaging.PersistenceMetadata;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Campus;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user=new Users();
		JpaCampusDao jpaCampus=(JpaCampusDao) request.getAttribute("jpacampus");
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPasswd(request.getParameter("password"));
		user.setEmailAdress(request.getParameter("email"));
		user.setIdCampus(jpaCampus.getCampusById( Long.parseLong(request.getParameter("Campus"))));
		
		
		JpaUsersDao jpaUser=new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		jpaUser.addUser(user);
		getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
		getServletConfig().getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);
	}

}
