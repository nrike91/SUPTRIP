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
 * Servlet implementation class RemoveTripInBagServlet
 */
@WebServlet("/RemoveTripInBagServlet")
public class RemoveTripInBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTripInBagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		JpaTripDao jpaTrip= new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaUsersDao jpaUser =new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		String id=request.getParameter("idTrip");
		List<Trip> list=new ArrayList<>();
		Trip trip=jpaTrip.findTripById(Long.parseLong(id));
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
		getServletContext().getRequestDispatcher("/page/finishprocess.jsp").forward(request, response);

	}
	
		
	}


