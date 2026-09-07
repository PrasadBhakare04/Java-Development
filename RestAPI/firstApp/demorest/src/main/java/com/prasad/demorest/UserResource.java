package com.prasad.demorest;



import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("user")
public class UserResource 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		User a1 = new User();
		a1.setName("Prasad");
		a1.setPoints(10);
		
		return a1;
	}
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		User a1 = new User();
		a1.setName("Prasad");
		a1.setPoints(10);
		
		User a2 = new User();
		a2.setName("John");
		a2.setPoints(20);
		
		List<User> users = new ArrayList<>();
		
		users.add(a1);
		users.add(a2);
		
		return users;
	}
	
	
}
