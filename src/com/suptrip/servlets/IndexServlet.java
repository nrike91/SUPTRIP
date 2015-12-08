package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaUsersDao jpaUser = new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaCampusDao JpaCampus=new JpaCampusDao(PersistanceManager.getEntityManagerFactory());
		 request.setAttribute("jpauser", jpaUser);
		 request.setAttribute("jpatrip", jpaTrip);
		 request.setAttribute("jpacampus", JpaCampus);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
