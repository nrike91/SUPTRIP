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

import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;

/**
 * Servlet implementation class ListTrip
 */
@WebServlet("/ListTrip")
public class ListTrip extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session=request.getSession();
		//Users user= (Users) session.getAttribute("user");
		JpaTripDao jpaTrip=(JpaTripDao) request.getAttribute("Jpatrip");
		List<Trip> listTrip=new ArrayList<>();
		listTrip=jpaTrip.getAllTripListByCampusName();
		getServletContext().getRequestDispatcher("/listtrip.jsp").forward(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
