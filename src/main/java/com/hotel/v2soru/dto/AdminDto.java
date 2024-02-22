package com.hotel.v2soru.dto;

import java.util.List;

import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminDto
{
	private long adminId;

	private String adminName;

	private String adminEmail;
	
	private long adminContact;
	
	private List<User> managedUsers; 

	private List<DeliveryBoy> managedDeliveryBoys;
    
}
