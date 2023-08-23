package com.osttra.service;

import java.util.Scanner;

import com.osttra.dao.BookDao;
import com.osttra.pojo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	
	Scanner sc = new Scanner(System.in);
	BookDao bookDao = new BookDao();
	
	public Book addBook()
	{
		System.out.println("Enter Book Name @");
		String bookName = sc.next();
		
		System.out.println("Enter Author Name @");
		String authorName = sc.next();
		
		System.out.println("Enter Description @");
		String description= sc.next();
		
		System.out.println("Enter BookId @");
		int bookId = sc.nextInt();
		
		Book book = new Book(bookName,authorName,description,bookId);	
		
		bookDao.createBook(book);
		
		return book;
	}
	public void getBooks()
	{
		List<Book> books =  bookDao.getAllBooks();
		for(Book book : books)
		{
			System.out.println(book);
		}
	}
	public void getBook()
	{
		System.out.println("Enter Book ID @");
		int bookId= sc.nextInt();
		Book book=  bookDao.getBook(bookId);
		System.out.println(book);
		
	}
}
