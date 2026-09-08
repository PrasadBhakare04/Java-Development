package com.prasad.demorest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("userdb")
public class UserDBResource {
	static {
		try {
			Class.forName("UserDBRepository");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		User user = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = UserDBRepository.getConn();
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

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() {
		List<User> users = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = UserDBRepository.getConn();
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
	
	@POST
	public User createUser(User u) {
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
