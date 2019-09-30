package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ActiveEntity;
import com.revature.services.ActiveEntityService;

@Controller
@RequestMapping("/activeEntity")
public class ActiveEntityController {

	private ActiveEntityService aes;

	@Autowired
	public ActiveEntityController(ActiveEntityService aes) {
		this.aes = aes;
	}

	@GetMapping("/return/{id}")
	public ResponseEntity<List<ActiveEntity>> returnActiveEntities(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<>(aes.returnAllActiveEntitesByCampaign(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/saveEntities", method = RequestMethod.POST)
	public ResponseEntity<String> storeEntities(@RequestBody String rawJson) {
		System.out.println(rawJson);
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity<String> response = null;
		ActiveEntity activeEntities;
		try {
			activeEntities = mapper.readValue(rawJson, ActiveEntity.class);
			System.out.println(activeEntities.toString());
			aes.storeActiveEntities(activeEntities);
			response = new ResponseEntity<>("Entities are added", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>("Entites are not added", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@PostMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteEntity(@PathVariable("id") int id){
		ResponseEntity<String> response = null;
		try {
			this.aes.deleteActiveEntity(id);
			response = new ResponseEntity<>("deleted", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>("Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
}
