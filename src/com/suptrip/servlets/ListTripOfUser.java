package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suptrip.entities.Users;

/**
 * Servlet implementation class ListTripOfUser
 */
@WebServlet("/ListTripOfUser")
public class ListTripOfUser extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session= request.getSession();
		Users user=(Users) session.getAttribute("user");
		request.setAttribute("list", user.getTrip());
		getServletContext().getRequestDispatcher("/page/listtripofuser.jsp").forward(request, response);

	}

}
