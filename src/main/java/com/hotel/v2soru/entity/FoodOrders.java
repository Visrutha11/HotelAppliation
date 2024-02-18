package com.hotel.v2soru.entity;

import java.util.List;

import org.hibernate.type.OrderedSetType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
public class FoodOrders 
{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long foodOrderId;
	    
	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<FoodItems> items;

	    private long totalCost;
	    
	    private OrderedSetType orderStatus;

       
}
