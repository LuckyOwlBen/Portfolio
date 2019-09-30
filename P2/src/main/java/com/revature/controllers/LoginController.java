package com.revature.controllers;

import java.io.StringReader;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.services.CampaignService;
import com.revature.services.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController{
	private LoginService ls;
	private CampaignService cs;
	
	@Autowired
	public LoginController(LoginService ls, CampaignService cs) {
		this.ls = ls;
		this.cs = cs;
	}
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<User>>gimmePeople(){
		return new ResponseEntity<>(ls.gimmeUsers(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/cheats", method=RequestMethod.GET)
	public ResponseEntity<List<Credentials>>gimmeUrPassword(){
		return new ResponseEntity<>(ls.gimmeUrPassword(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> login(@RequestBody String rawJson){
		ResponseEntity<User> response = null;
		JsonReader jsonReader = Json.createReader(new StringReader(rawJson));
		JsonObject json = jsonReader.readObject();
		jsonReader.close();
		System.out.println(json);
		String email = json.getString("email");
		String password = json.getString("password");
		User u  = null;
		try {
			u = ls.loginTest(email, password);
			response = new ResponseEntity<>(u ,HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
