package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PlayerBean;
import com.repository.PlayerRepository;

@Service
public class PLayerDao {

	@Autowired
	PlayerRepository playerRepository;
	
	public PlayerBean addPlayer(PlayerBean playerBean) {
		
		return playerRepository.save(playerBean);
		
	}
	
	public List<PlayerBean> getAllPlayers(){
		
		return playerRepository.findAll();
		
	}
	
}
