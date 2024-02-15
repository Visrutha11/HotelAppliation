package com.hotel.v2soru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.v2soru.entity.FoodItems;

public interface FooditemRepo extends JpaRepository<FoodItems, Long> 
{

}
