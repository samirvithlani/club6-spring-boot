package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bean.TeamBean;
import com.repository.TeamRepository;

@Service
public class TeamDao {

	@Autowired
	TeamRepository teamRepository;

	public TeamBean createTeam(TeamBean teamBean) {

		try {
			return teamRepository.save(teamBean);
		} catch (Exception e) {

			return null;
		}
	}
	
	public Optional<TeamBean> getTeamById(int id) {
		
		
		return teamRepository.findById(id);
		
	}
	
	public Page<TeamBean> getAllTeams(int pageNo,int size){
		
		//return teamRepository.findAllWithPlayers();
		Pageable pageable = PageRequest.of(pageNo,size);
		return teamRepository.findAll(pageable);
		
	}
	
	public void removeTeam(int teamId) {
		
		
		teamRepository.deleteById(teamId);
		
	}

}
