package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.ParseMethods;
import com.revature.services.ReimbursementUtility;

@WebServlet("/denyReimbursement")
public class DenyReimbursement extends HttpServlet{

	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		session = request.getSession(false);
		if (session != null) {
			ReimbursementUtility ru = new ReimbursementUtility();
			ParseMethods pu = new ParseMethods();
			String rawREID = request.getParameter("id");
			String rawEmployeeID = session.getAttribute("eId").toString();
			int reid = pu.tryParseInt(rawREID);
			int empId = pu.tryParseInt(rawEmployeeID);
			ru.denyReimbursementRequest(reid,empId);
			response.sendRedirect("employeeHomePage");

		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
