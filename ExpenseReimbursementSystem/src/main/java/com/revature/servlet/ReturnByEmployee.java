package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.beans.ReimbursementRequest;

import com.revature.services.ParseMethods;
import com.revature.services.ReimbursementUtility;

@WebServlet("/returnByEmployee")
public class ReturnByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();
	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		session = request.getSession(false);
		if (session != null) {
			ReimbursementUtility ru = new ReimbursementUtility();
			ParseMethods pu = new ParseMethods();
			List<ReimbursementRequest> tempList = new ArrayList<>();

			session = request.getSession(false);
			if (session != null) {

				String rawId = request.getParameter("empid");
				int id = pu.tryParseInt(rawId);
				tempList.addAll(ru.returnRequestsByEmployeeID(id));
				
				if (!tempList.isEmpty()) {
					PrintWriter out = response.getWriter(); // creates a printable object to be sent to the client
					String requestJSON = mapper.writeValueAsString(tempList); // turns the list into a mapped json string														
					response.setContentType("application/json"); // formats the response content to json
					response.setCharacterEncoding("UTF-8"); // formats the response to 8 bit unicode
					out.print(requestJSON); // executed the printwriter statement
					out.flush(); // clears the stream when it's done
				} else {
					response.sendError(403);
				}
			}

			else {
				response.sendRedirect("login");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
