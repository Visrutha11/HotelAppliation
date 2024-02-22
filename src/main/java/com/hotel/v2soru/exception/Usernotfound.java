package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class Usernotfound extends RuntimeException
{ 
	
	String message;

    public String getMessage()
    {
	  return message;
     }
	public Usernotfound (String message)
	{
	   	  super();
	   	  this.message=message;
	     }
}
