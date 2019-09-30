package com.revature.controllers;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.services.RegistrationService;
import com.revature.util.EmailTakenException;
import com.revature.util.NullFieldException;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private RegistrationService rs;
	
	@Autowired
	public RegistrationController(RegistrationService rs) {
		this.rs = rs;
	}
	
	@PostMapping
	public ResponseEntity<String> addNewUser(@RequestBody String rawJson){
		ResponseEntity<String> response = null;
		response = new ResponseEntity<>("New User registered, congratulations, nerd.", HttpStatus.CREATED);
		JsonReader jsonReader = Json.createReader(new StringReader(rawJson));
		JsonObject json = jsonReader.readObject();
		jsonReader.close();
		try {
			rs.addNewUser(json);
		} catch (NullFieldException | EmailTakenException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
}
