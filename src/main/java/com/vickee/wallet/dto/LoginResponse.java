package com.vickee.wallet.dto;

public class LoginResponse {
	
	private Long userId;
	
	private String userName;
	
	private String email;
	
	private String message;

	public LoginResponse(Long userId, String userName, String email, String message) {
		this.message = message;
		this.email = email;
		this.userName = userName;
		this.userId = userId;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		message = message;
	}
}
