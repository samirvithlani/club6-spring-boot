package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.TeamBean;

@Repository
public interface TeamRepository extends JpaRepository<TeamBean, Integer>{

	@Query("SELECT DISTINCT t FROM TeamBean t LEFT JOIN FETCH t.players")
	List<TeamBean> findAllWithPlayers();
	
}
