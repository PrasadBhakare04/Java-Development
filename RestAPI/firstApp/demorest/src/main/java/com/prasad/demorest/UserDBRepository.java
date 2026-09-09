package com.prasad.demorest;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
	
	public static User searchUser(String id) {
		User user = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement("Select * from restuser where id=" + id);
			rs = ps.executeQuery();

			if(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				int points = rs.getInt(3);

				user = new User(idx, name, points);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public static List<User> getUsers(){
		List<User> users = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement("Select * from restuser");
			rs = ps.executeQuery();

			while (rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				int points = rs.getInt(3);
				User user = new User(idx, name, points);
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	public static User createUser(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = UserDBRepository.getConn();
			ps = conn.prepareStatement("insert into restuser values(?,?,?)");
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setInt(3, u.getPoints());
			int affectedRows = ps.executeUpdate();
			System.out.println(affectedRows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return u;
	}
}
