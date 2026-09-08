package com.prasad.demorest;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	static List<User> users = new ArrayList<>();
	 
	public static List<User> createRepo() {
		System.out.println("repo created");
		
		User a1 = new User(1, "Prasad", 10);
		User a2 = new User(2, "John", 20);
		User a3 = new User(3, "Doe", 100);
		
		users.add(a1);
		users.add(a2);
		users.add(a3);
		
		return users;
	}
	
	public static List<User> getUsers(){
		return users;
	}
	
	
	public static void addRepo(User u) {
		users.add(u);
	}
	
	public static User getUser(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return new User();
	}
}
