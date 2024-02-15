package com.hotel.v2soru.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Admin 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int adminId;
	    private String adminname;
	    private String adminemail;	    
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<User>manageusers;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<FoodOrders>manageorders;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<DeliveryBoy>managedeliverboy;
}