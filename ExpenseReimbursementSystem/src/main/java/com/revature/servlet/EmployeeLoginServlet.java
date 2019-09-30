package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.services.Login;

@WebServlet("/login")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getRootLogger();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("EmployeeLoginPage.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Login login = new Login();
		HttpSession session = request.getSession();
		String username = request.getParameter("EmployeeUserName");
		String password = request.getParameter("EmployeePassword");
		boolean test = login.loginTest(username, password);

		if (test == true) {
			session = makeMeACookie(username, session);
			log.trace("Login occured for profile "+  session.getAttribute("email").toString());
			response.sendRedirect("employeeHomePage");
		} else {
			response.sendRedirect("login");
		}

	}

	public HttpSession makeMeACookie(String username, HttpSession session) {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Employee e = null;
		try {
			e = edi.returnEmployeeSQL(username);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		session.setAttribute("eId", e.getEmployeeId());
		session.setAttribute("departmentId", e.getDepartmentId());
		session.setAttribute("firstName", e.getFirstName());
		session.setAttribute("lastName", e.getLastName());
		session.setAttribute("email", e.getEmail());
		session.setAttribute("username", e.getUserName());
		session.setAttribute("reportsTo", e.getReportsTo());
		session.setAttribute("managerOf", e.getManagerOf());

		return session;
	}

}
