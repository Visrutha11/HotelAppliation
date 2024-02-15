package com.hotel.v2soru.dto;

import java.util.List;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class AdminDto
{
    private long AdminId;
    private String AdminName;
    private String AdminEmail;
  
    private List<User> manageuser;
    private List<FoodOrders>managefoodorder;
    private List<DeliveryBoy>managedeliveryboys;
    
    
}
