package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PlayerBean;
import com.bean.TeamBean;
import com.dao.PLayerDao;
import com.dao.TeamDao;
import com.dto.PLayerDto;
import com.repository.TeamRepository;

@RestController
@RequestMapping("/player")
public class PLayerController {

	
	@Autowired
	PLayerDao pLayerDao;
	
	@Autowired
	TeamRepository teamRepository;
	
	@PostMapping(value = "/create")
	public ResponseEntity<?> addPlayer(@RequestBody PLayerDto pLayerDto) {
		
		//team -->id fetch team 
		
		Optional<TeamBean> optTeam =teamRepository.findById(pLayerDto.getTeamId());
		TeamBean teamBean = null;
		if(optTeam.isPresent()) {
			teamBean =optTeam.get();
		}
		
		
		PlayerBean playerBean = new PlayerBean();
		playerBean.setAge(pLayerDto.getAge());
		playerBean.setName(pLayerDto.getPlayerName());
		playerBean.setTeam(teamBean);
		
		
		
		PlayerBean bean = pLayerDao.addPlayer(playerBean);
		
		if(bean!=null) {
			
			return new ResponseEntity<PlayerBean>(bean, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<PlayerBean>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
	}
	
	
	@GetMapping(value = "/players")
	public ResponseEntity<?> getAllPLayers(){
		
		
		List<PlayerBean> players  = pLayerDao.getAllPlayers();
		return new ResponseEntity<List<PlayerBean>>(players, HttpStatus.OK);
		
	}
	
}
