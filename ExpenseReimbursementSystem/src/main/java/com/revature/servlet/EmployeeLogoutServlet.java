package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class EmployeeLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getRootLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
		try {
			log.trace("User "+ session.getAttribute("email").toString() +" has logged out");
			session.invalidate();
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		}
		response.sendRedirect("login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
