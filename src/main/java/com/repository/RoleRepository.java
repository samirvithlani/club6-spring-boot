package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public interface RoleRepository extends JpaRepository<RoleBean, Integer> {

}
