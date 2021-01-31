package com.cg.lib.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookIssue")
public class BookIssue {
	
	@Id
	private String userName;
	
	private LocalDate issueBookDate;
	
	private LocalDate returnBookDate;
	
	@OneToMany
	private Books book;

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

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "BookIssue [userName=" + userName + ", issueBookDate=" + issueBookDate + ", returnBookDate="
				+ returnBookDate + ", book=" + book + "]";
	}

	public BookIssue() {
		super();
	}

	public BookIssue(String userName, LocalDate issueBookDate, LocalDate returnBookDate, Books book) {
		super();
		this.userName = userName;
		this.issueBookDate = issueBookDate;
		this.returnBookDate = returnBookDate;
		this.book = book;
	}
	
	
}
