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
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		JpaTripDao jpaTrip= new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaUsersDao jpaUser =new JpaUsersDao(PersistanceManager.getEntityManagerFactory());		
		String id=request.getParameter("idTrip");
		
		Trip trip;
		String option=null;
		option=(String)request.getParameter("processbuy");
		//option1=(String)request.getParameter("pocessremove");
		if (option.equals("process")) {
			trip=jpaTrip.findTripById(Long.parseLong(id));
			request.setAttribute("c", trip);
			getServletContext().getRequestDispatcher("/page/process.jsp").forward(request, response);
		} else {
			List<Trip> list=new ArrayList<>();
			 trip=jpaTrip.findTripById(Long.parseLong(id));
			list=user.getTrip();
			for (Trip trip2 : list) {
				if (trip2.getIdTrip()==trip.getIdTrip()) {
					trip=trip2;
				}
			}
			
			list.remove(trip);
			jpaUser.updateUser(user);
			session.removeAttribute("user");
			session.setAttribute("user", user);
			request.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/page/listtripofuser.jsp").forward(request, response);

		}
		

	}

}
