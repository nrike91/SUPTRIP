package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Users;

/**
 * Servlet implementation class AddTripInBag
 */
@WebServlet("/AddTripInBag")
public class AddTripInBag extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		JpaUsersDao jpaUser = (JpaUsersDao) request.getAttribute("jpauser");
		JpaTripDao jpaTrip=(JpaTripDao) request.getAttribute("jpatrip");
		jpaUser.addTripInBag(user, jpaTrip.findTripById(Long.parseLong(request.getParameter("trip"))));
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);

		
	}

	

}
