package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class Login {
	
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	
	
	public boolean loginTest(String username, String password) {
		List<Employee> loginVerify = new ArrayList<>();

		try {
			loginVerify.addAll(edi.returnAllEmployeesSQL());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	
		for(Employee e :loginVerify) {
			if(e.getUserName() == null) {
				return false;
			}
			if(e.getUserName().equals(username)){ 
				if(e.getPassword().equals(password)) {
					return true;
				}
			}
		}
	
		return false;
	}


}
