package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class DeliverryBoyListNotFound extends RuntimeException 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public DeliverryBoyListNotFound (String message) 
	{
		super();
		this.message = message;
	}
}
