package com.hotel.v2soru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.v2soru.entity.FoodItems;

public interface FooditemRepo extends JpaRepository<FoodItems, Long> 
{
	@Query("SELECT u FROM User u WHERE u.userEmail = :foodName")
	FoodItems findByfoodName(String foodName);
	
}
