package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.CurrentUser;

@WebServlet("/session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			String employeeID = session.getAttribute("eId").toString();
			String departmentID = session.getAttribute("departmentId").toString();
			String firstName = session.getAttribute("firstName").toString();
			String lastName = session.getAttribute("lastName").toString();
			String email = session.getAttribute("email").toString();
			String username = session.getAttribute("username").toString();
			String reportsTo = session.getAttribute("reportsTo").toString();
			String managerOf = session.getAttribute("managerOf").toString();
			CurrentUser c = new CurrentUser(employeeID ,departmentID, firstName, lastName, email, username, reportsTo, managerOf);
			response.getWriter().write((new ObjectMapper()).writeValueAsString(c));
		} 
		else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
