package com.prasad.demorest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String name;
	private int points;
	private int id;
	
	

	public User() {
		
	}
	
	public User(int id, String name, int points) {
		this.name = name;
		this.points = points;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
