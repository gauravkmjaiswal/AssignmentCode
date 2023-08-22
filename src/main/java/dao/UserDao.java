package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import db.DbConnection;
import entity.Book;
import entity.User;

public class UserDao {
	
	Connection connect = DbConnection.makeConnection();
	
	public User addUser (User user){
		
		try {
			PreparedStatement statement = connect.prepareStatement("insert into user values(?,?,?,?,?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2,user.getEmailId());
			statement.setString(3,user.getFirstName());
			statement.setString(4,user.getLastName());
			statement.setString(5,user.getPassword());
			statement.setString(6,user.getUserType());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error in UserDao.addUser method");
			e.printStackTrace();
		}
		return user;
	}
	public User getUser(String username,String password) {
		User user = null;
		try {
			PreparedStatement statement = connect.prepareStatement("select * from user where username = ? and password = ?");
			statement.setString(1,username);
			statement.setString(2,password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				String objectUsername = resultSet.getString(1);
				String objectEmailId = resultSet.getString(2);
				String objectFirstName = resultSet.getString(3);
				String objectLastName = resultSet.getString(4);
				String objectPassword = resultSet.getString(5);
				String objectUserType = resultSet.getString(6);
				user = new User(objectUsername,objectPassword,objectEmailId,objectFirstName,objectLastName,objectUserType);
				
			}
		} catch(Exception e)
		{
			System.out.println("Error in UserDao.getUser method");
			e.printStackTrace();
		}
		
		return user;
		
	}
	public List<User> getAllUsers()
	{
		ResultSet resultSet = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from user");
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{

				String objectUsername = resultSet.getString(1);
				String objectEmailId = resultSet.getString(2);
				String objectFirstName = resultSet.getString(3);
				String objectLastName = resultSet.getString(4);
				String objectPassword = resultSet.getString(5);
				String objectUserType = resultSet.getString(6);
				
				User user = new User(objectUsername,objectPassword,objectEmailId,objectFirstName,objectLastName,objectUserType);
				users.add(user);
				
				
			}
		}catch(Exception e)
		{
			System.out.println("Error in BookDao.create method");
			e.printStackTrace();
		}
		return users;
		
	}
}
