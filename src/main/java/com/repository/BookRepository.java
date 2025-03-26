package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.BookBean;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer> {

}
