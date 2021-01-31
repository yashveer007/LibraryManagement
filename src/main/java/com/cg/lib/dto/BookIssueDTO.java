package com.cg.lib.dto;

import java.time.LocalDate;
import com.cg.lib.entity.Books;

public class BookIssueDTO {
	
	private String userName;
	
	private LocalDate issueBookDate;
	
	private LocalDate returnBookDate;
	
	private Books book;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getIssueBookDate() {
		return issueBookDate;
	}

	public void setIssueBookDate(LocalDate issueBookDate) {
		this.issueBookDate = issueBookDate;
	}

	public LocalDate getReturnBookDate() {
		return returnBookDate;
	}

	public void setReturnBookDate(LocalDate returnBookDate) {
		this.returnBookDate = returnBookDate;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
	
	
}
