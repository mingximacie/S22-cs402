package com.cs425.web.model;

public class Librarians {

	private String ID;
	private String name;
	private String password;
	private String zip;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Librarians [ID=" + ID + ", name=" + name + ", password=" + password + "]";
	}
}
