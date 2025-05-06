package com.dto;

public class AuthResponse {

	
	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
	
}
