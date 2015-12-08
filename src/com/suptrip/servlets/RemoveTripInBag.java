package com.suptrip.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

/**
 * Servlet implementation class RemoveTripInBag
 */
@WebServlet("/RemoveTripInBag")
public class RemoveTripInBag extends HttpServlet {



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		JpaUsersDao jpaUser = (JpaUsersDao) session.getAttribute("jpauser");
		JpaTripDao jpaTrip=(JpaTripDao) session.getAttribute("jpatrip");
		jpaUser.removeTripInbag(user, jpaTrip.findTripById(Long.parseLong(request.getParameter("trip"))));
		
		
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
