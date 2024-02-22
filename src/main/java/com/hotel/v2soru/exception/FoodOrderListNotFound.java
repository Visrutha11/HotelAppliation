package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class FoodOrderListNotFound extends RuntimeException 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public FoodOrderListNotFound(String message) {
		super();
		this.message = message;
	}

}
