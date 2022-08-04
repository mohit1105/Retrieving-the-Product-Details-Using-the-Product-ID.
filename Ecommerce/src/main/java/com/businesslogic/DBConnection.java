package com.businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con=null;
	public static Connection getMyConnection() {
		try{  
			//step1 load the driver class  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 
			 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","Mohit@1105");  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
		
		}

}