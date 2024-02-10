package com.hotel.v2soru.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter@AllArgsConstructor
@Component
public class FoodItems 
{
	 private int itemId;
	    private String name;
	    private String description;
	    private double price;
}
