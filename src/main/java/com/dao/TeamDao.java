package com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

}
