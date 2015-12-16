package com.suptrip.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suptrip.dao.jpa.JpaCampusDao;
import com.suptrip.util.PersistanceManager;

/**
 * Servlet implementation class ViewRegisterServlet
 */
@WebServlet("/ViewRegisterServlet")
public class ViewRegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
		JpaCampusDao jpaCampus =new JpaCampusDao(PersistanceManager.getEntityManagerFactory());

		request.setAttribute("campus",jpaCampus.getAllCampus() );
		getServletContext().getRequestDispatcher("/auth/register.jsp").forward(request, response);

	}

}
