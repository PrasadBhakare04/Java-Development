package com.prasad.demorest;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class UserDBRepository {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		 Properties properties = new Properties();
	     String path = "E:\\Programming\\Config\\db.properties";
		 
		 Connection conn = null;
		 try(FileInputStream fis = new FileInputStream(path)) {
			 properties.load(fis);

	         String username = properties.getProperty("username");
	         String password = properties.getProperty("password");
			 String url = "jdbc:mysql://localhost:3306/prasad";
			 conn = DriverManager.getConnection(url, username, password);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return conn;
	 }
}
