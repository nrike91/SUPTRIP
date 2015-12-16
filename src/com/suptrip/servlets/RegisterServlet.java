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
import com.suptrip.dao.jpa.JpaTripDao;
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
		JpaUsersDao jpaUser = new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaCampusDao jpaCampus=new JpaCampusDao(PersistanceManager.getEntityManagerFactory());
		//JpaCampusDao jpaCampus=(JpaCampusDao) request.getAttribute("jpacampus");
		//JpaUsersDao jpaUser=(JpaUsersDao) request.getAttribute("jpauser");
		user.setFirstName(request.getParameter("first_name"));
		user.setLastName(request.getParameter("last_name"));
		user.setPasswd(request.getParameter("password"));
		user.setEmailAdress(request.getParameter("email"));
		user.setIdCampus(jpaCampus.getCampusById(Long.parseLong(request.getParameter("Campus"))));
		jpaUser.addUser(user);
		//request.setAttribute("campus",jpaCampus.getAllCampus() );
		getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		
	}
	

}
