package com.cg.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lib.dto.BookIssueDTO;
import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.BookIssue;
import com.cg.lib.entity.Books;
import com.cg.lib.entity.User;
import com.cg.lib.service.UserServiceImpl;
import com.cg.lib.util.Util;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private String userName;
	
	@Autowired
	private UserServiceImpl userService;
	
	/**
     * register User to the database
     * 
     *
     * @param UserDTO
     * @return response to server(String)
     */
	@PostMapping("/registerUser")
	public ResponseEntity<String> registration(@RequestBody UserDTO dto)
	{
		User newUser = Util.DtoToUser(dto);
		String result = userService.registration(newUser);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	/**
    * Login User 
    * 
    *
    * @param username and password
    * @return response to server(String)
    */
	@GetMapping("/validate/{username}/{password}")
	public ResponseEntity<String> validation(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		this.userName=username;
		String result = userService.validation(username, password);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	/**
    * Issue Book to the User 
    * 
    *
    * @param BookIssueDTo
    * @return response to server(String)
    */
	@PostMapping("/issueBooks")
	public ResponseEntity<String> issueBooks(@RequestBody BookIssueDTO bookIssueDto)
	{
		bookIssueDto.setUserName(userName);
		BookIssue bookIssue=Util.dtoToBookIssue(bookIssueDto);
		String result=userService.bookIssued(bookIssue);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
		
	}
	
	/** 
    * List Of Books
    *
    * @param NOArgs
    * @return list of BOOk
    */
	@GetMapping("/getAllBookList")
	public ResponseEntity<List<Books>> listOfBooks(){
		
		List<Books> allBooks=userService.listOfBooks();
		ResponseEntity<List<Books>> response = new ResponseEntity<List<Books>>(allBooks, HttpStatus.OK);
		return response;
	}

}
