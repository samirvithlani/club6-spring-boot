package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TeamBean;
import com.dao.TeamDao;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	TeamDao teamDao;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createTeam(@RequestBody TeamBean teamBean) {

		TeamBean team = teamDao.createTeam(teamBean);
		if (team != null) {

			return new ResponseEntity<TeamBean>(team, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<TeamBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/teams")
	public ResponseEntity<?> getAllTeams(@RequestParam("pageNo") int pageNo, @RequestParam("size") int pageSize) {

		Page<TeamBean> page = teamDao.getAllTeams(pageNo, pageSize);
		List<TeamBean> teams = page.getContent();

//		List<TeamBean> teams = teamDao.getAllTeams();
		return new ResponseEntity<List<TeamBean>>(teams, HttpStatus.OK);

	}

	@DeleteMapping(value = "/team/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable("id") int id) {

		teamDao.removeTeam(id);
		return new ResponseEntity<String>("team deleted", HttpStatus.OK);
	}

}
