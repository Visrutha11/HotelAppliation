package com.hotel.v2soru.dto;

import java.util.List;



import com.hotel.v2soru.entity.FoodOrders;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto
{
	 private int userId;
	    private String username;
	    private String email;
	    private List<FoodOrders> foodorders;
		
}
