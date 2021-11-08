package com.udacity.jwdnd.course1.cloudstorage.entity;

public class Credential {
	private Integer credentialId;
	private String url;
	private String username;
	private String token;
	private String password;
	private Integer userId;
	
	
	public Credential(Integer credentialId, String url, String username, String token, String password,
			Integer userId) {
		this.credentialId = credentialId;
		this.url = url;
		this.username = username;
		this.token = token;
		this.password = password;
		this.userId = userId;
	}
	
	public Integer getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
