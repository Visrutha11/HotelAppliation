package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.FoodItems;
import com.hotel.v2soru.repository.FooditemRepo;
@Repository
public class FoodItemDao
{
	@Autowired
	private FooditemRepo foodItemRepo;
	
	public FoodItems findFoodItem(long foodItemId) {
		
		Optional<FoodItems> foodItem = foodItemRepo.findById(foodItemId);
		if(foodItem.isPresent()) {
		return	foodItemRepo.findById(foodItemId).get();
		}
		return null;
	}
	
	public List<FoodItems> findAllFoodItem() {
		
		return foodItemRepo.findAll();
	}
	
	public FoodItems saveFoodItem(FoodItems foodItem) {
		
		return foodItemRepo.save(foodItem);
		
	}
	
	public FoodItems updateFoodItem(long foodId , FoodItems foodItem) {
		
		FoodItems exfoodItem = findFoodItem(foodId);
		if(exfoodItem.getItemId() == foodId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(foodItem , exfoodItem);
		foodItemRepo.save(exfoodItem);
		return exfoodItem;
		}
		return null;
	}
	
	public FoodItems deleteFoodItem(long foodId) {
		FoodItems fooditem = findFoodItem(foodId);
		
		if(fooditem.getItemId() == foodId) {
			foodItemRepo.deleteById(foodId);
			return fooditem;
		}
		return null;
	}
}
