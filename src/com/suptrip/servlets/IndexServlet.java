package com.suptrip.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Campus;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

	 Trip trip1,trip2,trip3;
		List<Trip> listTrip=new ArrayList<>();
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaUsersDao jpaUser = new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
		JpaCampusDao JpaCampus=new JpaCampusDao(PersistanceManager.getEntityManagerFactory());
		ServletContext context=getServletContext();
		 request.setAttribute("jpauser", jpaUser);
		 request.setAttribute("jpatrip", jpaTrip);
		 request.setAttribute("jpacampus", JpaCampus);
		 
		
			
				Users user=new Users();
				
				
			
				//jpaUser.removeUser(user);
				
				trip1 = new Trip();
				trip1.setDescription("Tour du monde ");
				//JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
				jpaTrip.addTrip(trip1);
				
				trip2 = new Trip();
				trip2.setDescription("Tour de la france  ");
				
				jpaTrip.addTrip(trip2);
				
				trip3 = new Trip();
				trip3.setDescription("Tour du faso  ");
				jpaTrip.addTrip(trip3);
				
				
				Campus campus =new Campus();
				JpaCampusDao jpaCampus =new JpaCampusDao(PersistanceManager.getEntityManagerFactory());
				campus.setCampusName("Esi/App");
				user.setFirstName("Moussa");
				user.setLastName("Mamadou");
				user.setPasswd("Password");
				user.setEmailAdress("moussa@moussa.com");
				user.setIdCampus(campus);
				//user.setBag(bag);
				listTrip.add(trip1);
				listTrip.add(trip2);
				listTrip.add(trip3);
				
				
				
				user.setTrip(listTrip);
				
				campus.setTrip(listTrip);
				jpaCampus.addCampus(campus);

				//JpaUsersDao jpaUser=new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
				jpaUser.addUser(user);
				
				request.setAttribute("trips",jpaTrip.getAllTrip());
				request.setAttribute("nbTrip",jpaTrip.getAllTrip().size());
				request.setAttribute("nbcampus",jpaCampus.getAllCampus().size() );
				request.setAttribute("nbUsers", jpaUser.getUserAllUsers().size());
		 
		 
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		//getServletContext().getRequestDispatcher("/page/listtrip.jsp").forward(request, response);


	}
	

}
