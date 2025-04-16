package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TeamBean;
import com.dao.TeamDao;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	
	@Autowired
	TeamDao teamDao;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createTeam(@RequestBody TeamBean teamBean){
		
		TeamBean team = teamDao.createTeam(teamBean);
		if(team!=null) {
			
			return new ResponseEntity<TeamBean>(team, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<TeamBean>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
}
