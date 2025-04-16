package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.TeamBean;

@Repository
public interface TeamRepository extends JpaRepository<TeamBean, Integer>{

}
