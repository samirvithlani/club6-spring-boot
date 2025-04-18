package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.BookBean;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer> {

	@Query("SELECT b FROM BookBean b JOIN FETCH b.authors")
	List<BookBean> findAllWithAuthorBean();
	
}
