package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection makeConnection() {
		
		Connection connectionObject = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connectionObject = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "Microsoft@123");
			
		} catch (Exception e) {
			
			System.out.println("Connection error with Database : " + e);
			e.printStackTrace();
			
		}
		
		return connectionObject;
		
	}
}
