package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class EmployeeServices {

	public void updateEmployeeInfo(String username, String password, String email, String session) {

		EmployeeDAOImpl edi = new EmployeeDAOImpl();

		Employee e = null;
		try {
			e = edi.returnEmployeeSQL(session);
			e.toString();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.toString();
		if (username != "") {
			e.setUserName(username);
		}
		if (password != "") {
			e.setPassword(password);
		}
		if (email != "") {
			e.setEmail(email);
		}

		try {
			edi.updateEmployeeSQL(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public List<Employee> returnAllEmployees(){
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		List<Employee> tempList = new ArrayList<>();
		
		try {
			tempList.addAll(edi.returnAllEmployeesSQL());
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
