package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class Adminnotfound extends RuntimeException 
{
          String message;
          
          public String getMessage()
          {
        	  return message;
          }
          public Adminnotfound (String message)
          {
        	  super();
        	  this.message=message;
          }
          
}
