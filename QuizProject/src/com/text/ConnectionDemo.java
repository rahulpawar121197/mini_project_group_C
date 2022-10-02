package com.text;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDemo{


public Connection getConnection() {
	Connection con=null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	
	
	con =DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Rahul@sql");
	
	return con;
	}catch(Exception e)
	{
		e.printStackTrace();
		
		
	}
return con;
}




}
