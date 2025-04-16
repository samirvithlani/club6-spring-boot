package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.PlayerBean;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerBean,Integer>{

}
