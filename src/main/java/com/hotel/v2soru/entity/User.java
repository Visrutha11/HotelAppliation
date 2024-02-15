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
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int userId;
	    private String username;
	    private String email;
	    private String password;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<FoodOrders> foodorders;
}
