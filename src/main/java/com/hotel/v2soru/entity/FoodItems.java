package com.hotel.v2soru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class FoodItems 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int itemId;
	    private String name;
	    private String description;
	    private double price;
}
