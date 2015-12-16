package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.dao.jpa.JpaUsersDao;
import com.suptrip.entities.Users;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	JpaUsersDao jpaUser=new  JpaUsersDao(PersistanceManager.getEntityManagerFactory()) ;
	JpaCampusDao jpaCampus= new JpaCampusDao(PersistanceManager.getEntityManagerFactory());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		Users user=(Users) session.getAttribute("user");
		request.setAttribute("user", user);
		
		request.setAttribute("campus",jpaCampus.getAllCampus() );
		 
		getServletContext().getRequestDispatcher("/page/editprofile.jsp").forward(request, response);

		
	}
}
