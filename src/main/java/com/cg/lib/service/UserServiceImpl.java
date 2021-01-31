package com.cg.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lib.dao.IBookDAO;
import com.cg.lib.dao.IBookIssuedDAO;
import com.cg.lib.dao.IUserDAO;
import com.cg.lib.entity.BookIssue;
import com.cg.lib.entity.Books;
import com.cg.lib.entity.User;
import com.cg.lib.exception.AlreadyExists;
import com.cg.lib.exception.InvalidArgumentException;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private IBookDAO bookDao;
	
	@Autowired
	private IBookIssuedDAO bookIssueDao;
	
	/*
	 * This method is user for User Registration
	 * @Param it will takes User as an input 
	 * @return it will return String as a result
	 */
	@Override
	public String registration(User user) {
		if(user == null) {
			
			throw new InvalidArgumentException("Please filled register form again");
			
		}else {
			
			if(userDao.existsById(user.getUsername()))
			{
				throw new AlreadyExists("User already exists.");
			}
			userDao.save(user);
			return "User registered successfully";
		}
	}
	
	/*
	 * this method is used for user login,
	 * IF user credentials are right then it will return Login Sucessfully ,
	 * ELSE return Invalid Credentials
	 * 
	 * @Param Username,UserPassword from the controller
	 * @return String to the controller
	 * 
	 */
	@Override
	public String validation(String username, String password) {
		boolean userPresence = userDao.existsById(username);
		if(!userPresence) 
		{
			return "No such user present";
		}else {
			List<User> allUsers = userDao.findAll();
			for (User user : allUsers) 
			{ 
				if (user.getPassword().equals(password)) 
				{
					
					return "Login Successfully";
				}
			}
		}
		return "Invalid Credentials";
	}

	/*
	 * This method will return the lists of books present in the database
	 * @param NoArgs
	 * @return List of BOOks present in the database 
	 */
	@Override
	public List<Books> listOfBooks() {
		List<Books> allBooks=bookDao.findAll();
		if(allBooks == null) {
			throw new InvalidArgumentException("Something went Wonrg ! Retry Again");
		}
		return allBooks;
	}

	@Override
	public String bookIssued(BookIssue bookIssue) {
		if(bookIssue == null) {
			throw new InvalidArgumentException("Something went wrong, Retry Again for Issue Book");
		}else {
			bookIssueDao.save(bookIssue);
			return "Book Issued Sucessfully";
		}

	}
	

	
}
