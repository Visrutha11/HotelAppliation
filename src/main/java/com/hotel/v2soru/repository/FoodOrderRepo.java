package com.hotel.v2soru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.FoodOrders;

public interface FoodOrderRepo  extends JpaRepository<FoodOrders,Long> 
{

}
