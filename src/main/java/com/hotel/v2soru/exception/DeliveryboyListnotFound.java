package com.hotel.v2soru.exception;

public class DeliveryboyListnotFound  extends RuntimeException 
{
   
	private String message;

	public String getMessage() {
		return message;
	}

	public DeliveryboyListnotFound(String message) 
	{
		super();
		this.message = message;
	}

	
	
}
