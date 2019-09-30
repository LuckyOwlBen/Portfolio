package com.revature.services;

import com.revature.beans.Employer;
import com.revature.daoimpl.EmployeerDAOImpl;

public class EmployeeLogin {
	EmployeerDAOImpl edi = new EmployeerDAOImpl();
	
	public boolean verifyLogin(String email,String password) {
		
		Employer e = edi.returnEmployeeByUsername(email);
		if(e.equals(null)) {
			return false;
		}
		if(e.getEmail() == email) {
			if(e.getPassword() == password) {
				return true;
			}
		}
		return false;
		
	}
}
