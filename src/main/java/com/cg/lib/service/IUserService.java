package com.cg.lib.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.BookIssue;
import com.cg.lib.entity.Books;
import com.cg.lib.entity.User;

public interface IUserService {
	
	String validation(String username, String password);
	
	String registration(User user);
	
	List<Books> listOfBooks();
	
	String bookIssued(BookIssue bookIssue);
	
}
