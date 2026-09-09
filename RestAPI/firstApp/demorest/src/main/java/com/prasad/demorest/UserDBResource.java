package com.prasad.demorest;


import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("userdb")
public class UserDBResource {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		return UserDBRepository.searchUser(id);
	}

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() {
		return UserDBRepository.getUsers();
	}
	
	@POST
	public User createUser(User u) {
		return UserDBRepository.createUser(u);
	}
	
	@PUT
	public User updateUser(User u) {
		return UserDBRepository.update(u);
	}
	
	@DELETE
	@Path("{id}")
	public User deleteUser(@PathParam("id") String id) {
		return UserDBRepository.delete(id);
	}
}
