package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AuthorBean;
import com.bean.BookBean;
import com.dao.LibraryDao;
import com.repository.AuthorRepository;
import com.repository.BookRepository;

@RestController
public class LibraryController {

	@Autowired
	public AuthorRepository authorRepository;

	@Autowired
	public BookRepository bookRepository;

	@Autowired
	public LibraryDao libraryDao;

	@PostMapping("/authors")
	public AuthorBean createAuthor(@RequestBody AuthorBean authorBean) {

		return authorRepository.save(authorBean);
	}

	@PostMapping("/books")
	public BookBean createBook(@RequestBody BookBean bookBean) {

		return bookRepository.save(bookBean);
	}

	@PostMapping("/assign/{authorId}/{bookId}")
	public String assignAuthorToBook(@PathVariable("authorId") int authorId, @PathVariable("bookId") int Bookid) {

		libraryDao.addAuthorToBook(authorId, Bookid);
		return "book has been assigned..";
	}

}
