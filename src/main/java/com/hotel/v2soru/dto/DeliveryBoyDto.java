package com.hotel.v2soru.dto;

import com.hotel.v2soru.entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DeliveryBoyDto 
{
       
	 private long deliveryBoyId;
	    
	    private String deliveryBoyName;
	    
	    private String phoneNumber;
	    
	    private User user;
	
}
