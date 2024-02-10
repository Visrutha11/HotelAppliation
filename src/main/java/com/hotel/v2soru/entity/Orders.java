package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class Orders 
{
       private int orderId;
       private List<FoodItems>items;
       private String status;
	
       
}
