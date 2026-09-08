package com.prasad.demorest;



import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;

@Path("user")
public class UserResource 
{
	static List<User> repo;
	static {
		repo = UserRepository.createRepo();
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		User a1 = new User();
		a1.setName("Tony");
		a1.setPoints(10);
		
		return a1;
	}
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		
		return repo;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserA(@PathParam("id") String id) {
		
		int idn = Integer.parseInt(id);
		
		return UserRepository.getUser(idn);
	}
	
	@POST
	public List<User> postUser(User u) {
		repo.add(u);
		return repo;
	}
	
}
