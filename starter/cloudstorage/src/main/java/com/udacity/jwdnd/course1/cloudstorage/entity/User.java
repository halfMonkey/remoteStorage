package com.udacity.jwdnd.course1.cloudstorage.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	private Integer userId;
	
	@NotNull(message = "username cannot be null")
    private String username;
    private String salt;
    
    @Size(min=6, max= 20, message = "password should not be greater than 20 and smaller than 6")
    private String password;
    private String firstName;
    private String lastName;
	public User(Integer userId, String username, String salt, String password, String firstName, String lastName) {
		this.userId = userId;
		this.username = username;
		this.salt = salt;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
