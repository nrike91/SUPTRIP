package com.suptrip.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.CampusDao;
import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaTripDao;
import com.suptrip.dao.jpa.JpaUsersDao;

import com.suptrip.entities.Campus;
import com.suptrip.entities.Trip;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;
import com.suptrip.dao.jpa.*;

@WebServlet("/user")

public class UserAutentServlet extends HttpServlet implements Serializable{
	Trip trip1,trip2,trip3;
	List<Trip> listTrip=new ArrayList<>();
	
	@Override
	public void doGet(HttpServletRequest requet, HttpServletResponse reponse){
		Users user=new Users();
		
		
	
		//jpaUser.removeUser(user);
		
		trip1 = new Trip();
		trip1.setDescription("Tour du monde ");
		JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
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
		jpaCampus.addCampus(campus);
		user.setFirstName("Moussa");
		user.setLastName("Mamadou");
		user.setPasswd("Password");
		user.setEmailAdress("moussa@moussa.com");
		user.setIdcampus(campus);
		//user.setBag(bag);
		listTrip.add(trip1);
		listTrip.add(trip2);
		listTrip.add(trip3);

		
		
		user.setTrip(listTrip);
		JpaUsersDao jpaUser=new JpaUsersDao(PersistanceManager.getEntityManagerFactory());
		jpaUser.addUser(user);
		requet.setAttribute("campus",jpaCampus.getAllCampus() );
		
		
		try {
			getServletContext().getRequestDispatcher("/auth/register.jsp").forward(requet, reponse);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
