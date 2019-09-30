package com.revature.services;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.datalayer.LoginDAO;
import com.revature.util.EmailTakenException;
import com.revature.util.NullFieldException;

@Service
public class RegistrationService {

	private LoginDAO ld;
	
	@Autowired
	public RegistrationService(LoginDAO ld) {
		this.ld = ld;
	}
	
	//Split our form data into a new user and a new credentials object
	public void addNewUser(JsonObject body) throws NullFieldException, EmailTakenException{
		System.out.println(body);
		User temp = new User();
		Credentials creds = new Credentials();
		temp.setLastName(body.getString("lastName"));
		temp.setFirstName(body.getString("firstName"));
		temp.setEmail(body.getString("email"));
		if(temp.getEmail().isEmpty()) {
			throw new NullFieldException("Email field is empty!");
		}
		creds.setUser(temp);
		creds.setPassword(body.getString("password"));
		if(creds.getPassword().isEmpty()) {
			throw new NullFieldException("Password field is empty!");
		}
		if(ld.getUserByEmail(temp.getEmail()) != null) {
			throw new EmailTakenException("Email already in use.");
		}
		ld.createUser(temp, creds);
	}
}
