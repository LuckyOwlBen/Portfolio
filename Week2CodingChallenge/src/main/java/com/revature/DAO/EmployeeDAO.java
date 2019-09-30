package com.revature.DAO;

import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public void addNewEmployee(Employee e)
			throws SQLException;
	
	public void returnAllEmployees()
			throws SQLException;
}
