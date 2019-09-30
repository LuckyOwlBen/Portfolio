package com.revature.dao;

import com.revature.beans.Employer;

public interface EmployeerDAO {

	public void addEmployee(Employer e);
	
	public void updateEmployee(Employer e);
	
	public Employer returnEmployeeByUsername(String username); 
}
