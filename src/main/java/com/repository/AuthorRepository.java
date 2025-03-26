package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.AuthorBean;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorBean,Integer>{

}
