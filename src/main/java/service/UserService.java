package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ExcetionHandling.MinimumPasswordLengthException;
import ExcetionHandling.UserRoleException;
import dao.UserDao;
import entity.Book;
import entity.User;

public class UserService{
	
	Scanner sc = new Scanner(System.in);
	UserDao userDao = new UserDao();
	
	BookService bookService = new BookService();
	
	public User registerUser()
	{
		System.out.println("Enter Username @ ");
		String username = sc.next();
		
		System.out.println("Enter Password @");
		String password = sc.next();
		if(password.length()<8)
		{
			throw new MinimumPasswordLengthException(" Password length should be greater than or equal to 8");
		}
		
		System.out.println("Enter EmailId @");
		String emailId = sc.next();
		
		System.out.println("Enter First Name @");
		String firstName= sc.next();
		
		System.out.println("Enter Last Name @");
		String lastName= sc.next();

		System.out.println("Enter Role @");
		String userType = sc.next();
		if(!(userType.equals("admin") || userType.equals("normal")))
		{
			throw new UserRoleException("Invalid Role");
		}
		
		
		
		User user = new User(username,password,emailId,firstName,lastName,userType);
		userDao.addUser(user);
		return user;
		
	}
	
	public User getUser()
	{
		System.out.println("Enter Username @ ");
		String username = sc.next();
		
		System.out.println("Enter Password @");
		String password = sc.next();
		
		User user = userDao.getUser(username, password);
		return user;
	}
	
	
	public Book addBook(User user)
	{
		Book book = null;
		if(!user.getUserType().equals("admin"))
		{
			book = bookService.addBook();
			
		}
		else
		{
//			throw exception
			System.out.println("access denied");
		
		}
		return book;
	}
	public void getUsers()
	{
		List<User> users = userDao.getAllUsers();
		for(User user: users)
		{
			System.out.println(user);
		}
	}

}

