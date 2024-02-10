package com.hotel.v2soru.dto;

import java.util.List;

import com.hotel.v2soru.entity.DeviveryBoy;
import com.hotel.v2soru.entity.FoodItems;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.Userentity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class AdminDto
{
    private int AdminDtoid;
    private String AdminDtoname;
    private String AdminDtoPassword;
    private long AminDtoContact;
  
    private List<Userentity> manageuser;
    private List<FoodOrders>managefoodorder;
    private List<FoodItems>manageFooditems;
    private List<DeviveryBoy>managedelivery;
    
    
}
