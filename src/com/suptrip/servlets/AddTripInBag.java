package com.suptrip.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class AddTripInBag
 */
@WebServlet("/AddTripInBag")
public class AddTripInBag extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		JpaTripDao jpaTrip= new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaUsersDao jpaUser =new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		String id=request.getParameter("idTrip");
		List<Trip> list=new ArrayList<>();
		Trip trip=jpaTrip.findTripById(Long.parseLong(id));
		user.getTrip().add(trip);
		list=user.getTrip();
		jpaUser.updateUser(user);
		session.removeAttribute("user");
		session.setAttribute("user", user);
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/page/listtripofuser.jsp").forward(request, response);

		
		
	}

	
	

	

}
