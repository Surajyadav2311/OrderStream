package com.orderstream.auth.dto;

public class RegisterResponse {

	String fullname;
	String email;
	String username;
	String password;
	
	public String getEmail() {
		return email;
	}
	public String getFullname() {
		return fullname;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
