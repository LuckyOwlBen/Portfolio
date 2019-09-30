package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.ReimbursementRequest;
import com.revature.services.ParseMethods;
import com.revature.services.ReimbursementUtility;

@WebServlet("/submitRequest")
public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		session = request.getSession(false);
		
		if(session != null) {
			response.sendRedirect("employeeHomePage");
		}
		else {
			response.sendRedirect("login");
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(false);
		ParseMethods pm = new ParseMethods();
		ReimbursementUtility ru = new ReimbursementUtility();
		
		if(session != null) {
			
			String rawDollarAmount = request.getParameter("dollarAmount");
			String reason = request.getParameter("reason");
			String rawDptId = session.getAttribute("departmentId").toString();
			String rawEID = session.getAttribute("eId").toString();
			double dollarAmount = pm.tryParseDouble(rawDollarAmount);
			int eID = pm.tryParseInt(rawEID);
			int dptId = pm.tryParseInt(rawDptId);

			ReimbursementRequest rr = new ReimbursementRequest(eID,dollarAmount,reason,1 , dptId, 0);
			boolean test = ru.generateReimbursement(rr);
			if(test == true) {
				response.setStatus(200);
				response.getWriter().write("Request successfully submitted!");
				response.sendRedirect("employeeHomePage");
			}
			else {
				response.sendError(403);
				response.getWriter().write("NO!");
				response.sendRedirect("employeeHomePage");
			}
		}
		else {
			response.sendRedirect("login");
		}
	}

}
