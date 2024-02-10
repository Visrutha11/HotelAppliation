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
public class Adminentity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int adminId;
	    private String adminname;
	    private String adminemail;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<Userentity> user;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<FoodOrders>foodorders;
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<DeviveryBoy>deliverboy;
	   
	
}
