package com.hotel.v2soru.exception;


@SuppressWarnings("serial")
public class FoodListItemsNotFound extends RuntimeException 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public FoodListItemsNotFound(String message) 
	{
		super();
		this.message = message;
	}
}
