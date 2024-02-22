package com.hotel.v2soru.exception;

@SuppressWarnings("serial")
public class foodordernotofound extends RuntimeException
{
      String message;
     
     public String getMessage()
     {
   	  return message;
     }
     public foodordernotofound(String message)
     {
    	 super();
    	 this.message=message;
     }
}
