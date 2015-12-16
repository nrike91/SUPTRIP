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
import com.suptrip.entities.Campus;
import com.suptrip.entities.Trip;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class FindTrip
 */
@WebServlet("/FindTrip")
public class FindTrip extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			JpaTripDao jpaTrip=new JpaTripDao(PersistanceManager.getEntityManagerFactory());
			JpaCampusDao jpaCampus =new JpaCampusDao(PersistanceManager.getEntityManagerFactory());
			List<Campus> listc =jpaCampus.getAllCampus();
			List<Trip> list=new ArrayList<>();
			list=null;
			String search=request.getParameter("search");
			for (Campus campus : listc) {
				String name=campus.getCampusName();
				if (name.equals(search)) {
					list=campus.getTrip();
					request.setAttribute("campusname", name);
					request.setAttribute("list",list);
				}
				
			}
			if (list!=null) {
			
				getServletContext().getRequestDispatcher("/findtrip.jsp").forward(request, response);
			
			}else{
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
			}
	}

}
