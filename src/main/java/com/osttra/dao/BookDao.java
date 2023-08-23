package com.osttra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.osttra.db.DbConnection;
import com.osttra.pojo.Book;

public class BookDao {
	Connection connect =DbConnection.makeConnection();
	public void createBook(Book book)
	{
		try {
			PreparedStatement statement = connect.prepareStatement("insert into book values(?,?,?,?)");
			statement.setString(1, book.getBookName());
			statement.setString(2,book.getAuthorName());
			statement.setString(3,book.getDescription());
			statement.setInt(4,book.getBookId());
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Error in BookDao.create method");
			e.printStackTrace();
		}
	}
	public List<Book> getAllBooks()
	{
		ResultSet resultSet = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from book");
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String bookName = resultSet.getString(1);
				String authorName = resultSet.getString(2);
				String description = resultSet.getString(3);
				int bookId= resultSet.getInt(4);
				
				Book book = new Book(bookName,authorName,description,bookId);		
				books.add(book);
			}
		}catch(Exception e)
		{
			System.out.println("Error in BookDao.create method");
			e.printStackTrace();
		}
		return books;
		
	}
	public Book getBook(int Id)
	{
		ResultSet resultSet = null;
		Book book = null;
		try {
			PreparedStatement statement = connect.prepareStatement("select * from book where bookId = ?");
			statement.setInt(1,Id);
			resultSet = statement.executeQuery();
			if(resultSet.next())
			{

				String bookName = resultSet.getString(1);
				String authorName = resultSet.getString(2);
				String description = resultSet.getString(3);
				int bookId= resultSet.getInt(4);
				
				book = new Book(bookName,authorName,description,bookId);			
			}
		}catch(Exception e)
		{
			System.out.println("Error in BookDao.create method");
			e.printStackTrace();
		}
		return book;
		
	}
}
