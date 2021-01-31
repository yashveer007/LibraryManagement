package com.cg.lib.util;

import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.User;
import com.cg.lib.dto.BookIssueDTO;
import com.cg.lib.dto.BooksDTO;
import com.cg.lib.entity.BookIssue;
import com.cg.lib.entity.Books;

public class Util {
	
	public static User DtoToUser(UserDTO dto) {
		User newUser = new User();
		newUser.setDOB(dto.getDOB());
		newUser.setEmail(dto.getEmail());
		newUser.setFirstName(dto.getFirstName());
		newUser.setLastName(dto.getLastName());
		newUser.setMob_No(dto.getMob_No());
		newUser.setPassword(dto.getPassword());
		newUser.setUsername(dto.getUsername());
		newUser.setApproved(dto.getApproved());
		return newUser;
	}
	
	public static Books DtoToBooks(BooksDTO book) {
		Books newBook = new Books();
		newBook.setAuthorName(book.getAuthorName());
		newBook.setBookName(book.getBookName());
		newBook.setPublishedYear(book.getPublishedYear());
		return newBook;
	}
	
	public static BookIssue dtoToBookIssue(BookIssueDTO bookIssueDTO) {
		BookIssue bookIssue= new BookIssue();
		bookIssue.setUserName(bookIssueDTO.getUserName());
		bookIssue.setIssueBookDate(bookIssueDTO.getIssueBookDate());
		bookIssue.setReturnBookDate(bookIssueDTO.getReturnBookDate());
		bookIssue.setBook(bookIssueDTO.getBook());
		return bookIssue;
	}

}
