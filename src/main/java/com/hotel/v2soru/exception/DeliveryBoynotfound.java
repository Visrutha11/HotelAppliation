package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class DeliveryBoynotfound extends RuntimeException
{
	 String message;
     
     public String getMessage()
     {
   	  return message;
     }
     public DeliveryBoynotfound (String message)
     {
    	   	  super();
    	   	  this.message=message;     
     }
             
}
