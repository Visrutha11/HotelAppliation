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
public class DeviveryBoy 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DeliverBoyId;
    private String DeviveryBoyName;
    private String Phonenumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodOrders>orders;
}
