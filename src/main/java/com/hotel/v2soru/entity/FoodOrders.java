package com.hotel.v2soru.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class FoodOrders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
       private int orderId;
	   @OneToMany(cascade = CascadeType.ALL)
       private List<FoodItems>items;
       private String status;
	
       
}
