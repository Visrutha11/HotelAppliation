package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class UserListnotFound extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public UserListnotFound(String message) 
	{
		super();
		this.message = message;
	}
}
