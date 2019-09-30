package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Conditions;

@Controller
@RequestMapping("/conditions")
public class ConditionsController {
	
	//This will send an array
	@RequestMapping("/all")
	public ResponseEntity<Conditions[]> getAllConditions(){
		return new ResponseEntity<>(Conditions.values(),HttpStatus.OK);
	}

}
