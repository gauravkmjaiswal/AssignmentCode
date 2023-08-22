package entity;

import java.util.Arrays;

public class User {
	
	String username;
	String password;
	String emailId;
	String firstName;
	String lastName;
	String userType;
	boolean status;
	Book[] newBooks;
	Book[] favourite;
	Book[] completedBooks;
	
	public User(String username, String password, String emailId, String firstName, String lastName, String userType) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.status = true;  
	}
	public User() {
		// TODO Auto-generated constructor stub
		this.username = null;
		this.password = null;
		this.emailId = null;
		this.firstName = null;
		this.lastName = null;
		this.userType = null;
		this.status = false;
		this.newBooks = null;
		this.completedBooks = null;
		this.favourite = null;
	}
	public boolean getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", emailId=" + emailId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userType=" + userType + ", status=" + status + ", newBooks="
				+ Arrays.toString(newBooks) + ", favourite=" + Arrays.toString(favourite) + ", completedBooks="
				+ Arrays.toString(completedBooks) + "]";
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Book[] getNewBooks() {
		return newBooks;
	}
	public void setNewBooks(Book[] newBooks) {
		this.newBooks = newBooks;
	}
	public Book[] getFavourite() {
		return favourite;
	}
	public void setFavourite(Book[] favourite) {
		this.favourite = favourite;
	}
	public Book[] getCompletedBooks() {
		return completedBooks;
	}
	public void setCompletedBooks(Book[] completedBooks) {
		this.completedBooks = completedBooks;
	}
	
	
}
