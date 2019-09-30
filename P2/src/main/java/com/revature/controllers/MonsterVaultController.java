package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.MonsterVault;
import com.revature.services.MonsterVaultService;

@Controller
@RequestMapping("/monsterVault")
public class MonsterVaultController {
	
	private MonsterVaultService mvs;
	
	public MonsterVaultController(MonsterVaultService mvs) {
		this.mvs = mvs;
	}
	
	@RequestMapping("/returnAll")
	public ResponseEntity<List<MonsterVault>> returnAllMonsters(){
		return new ResponseEntity<>(mvs.getAllMonsters(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addMonster", method=RequestMethod.POST)
	public ResponseEntity<String> addMonster(@RequestBody MonsterVault monsterVault){
		ResponseEntity<String> response = null;
		try {
			mvs.addMonster(monsterVault);
			response = new ResponseEntity<>("Successfully added monster", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			response = new ResponseEntity<>("Failed to create monster", HttpStatus.BAD_REQUEST);
		}
		return response;
		
		
	}

	

}
