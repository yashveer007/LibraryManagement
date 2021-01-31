package com.cg.lib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lib.dao.IAdminDAO;
import com.cg.lib.dao.IBookDAO;
import com.cg.lib.entity.Books;
import com.cg.lib.exception.BookNotFoundException;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminDAO admoinDAO;
	
	@Autowired
	private IBookDAO bookDAO;

	@Override
	public String adminLogin(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) {
			return "Admin login successful...";
		}else {
			return "Invalid entries...";
		}
	}

	@Override
	public List<Books> viewAllBooks() {
		List<Books> allBooks = bookDAO.findAll();
		return allBooks;
	}
	
	@Override
	public String addBook(Books newBook) {
		bookDAO.save(newBook);
		return "Book added successfully...";
	}

	@Override
	public String editBook(Books newBook) {
		Optional<Books> previousBook = bookDAO.findById(newBook.getBookName());
		if(!previousBook.isPresent()) {
			throw new BookNotFoundException("No such book present...");
		}else {
			bookDAO.save(newBook);
			return "Book updated successfully...";
		}
	}

	@Override
	public String deleteBook(String bookName) {
		if(!bookDAO.existsById(bookName)) {
			throw new BookNotFoundException("No such book present...");
		}else {
			bookDAO.deleteById(bookName);
			return "Book deleted successfully...";
		}
	}	
	

}
