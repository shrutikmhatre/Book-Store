package com.book.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCConnection {
	static Connection dbConnect;
	
	
	public static Connection getConnection()  {
		
	
		String url="jdbc:mysql://localhost:3306/OnlineBookStore";
		String username="root";
		String password="Shrutik@123";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dbConnect=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return dbConnect;
		
		
		
		
	}
}
