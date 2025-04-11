package com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bean.AuthorBean;
import com.bean.BookBean;
import com.repository.AuthorRepository;
import com.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class LibraryDao {

	@Autowired
	public AuthorRepository authorRepository;
	@Autowired
	public BookRepository bookRepository;

	@Transactional
	public void addAuthorToBook(int authorId, int bookId) {

		Optional<AuthorBean> authorOpt = authorRepository.findById(authorId);
		Optional<BookBean> bookOpt = bookRepository.findById(bookId);

		if (authorOpt.isPresent() && bookOpt.isPresent()) {

			AuthorBean authorBean = authorOpt.get(); // author
			BookBean bookBean = bookOpt.get(); //book

			bookBean.getAuthors().add(authorBean); //set
			authorBean.getBooks().add(bookBean);
			bookRepository.save(bookBean);

		}

	}

}
