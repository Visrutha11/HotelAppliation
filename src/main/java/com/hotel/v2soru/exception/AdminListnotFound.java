package com.hotel.v2soru.exception;
@SuppressWarnings("series")
public class AdminListnotFound  extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public AdminListnotFound(String message) 
	{
		super();
		this.message = message;
	}

}
