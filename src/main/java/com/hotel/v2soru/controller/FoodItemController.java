package com.hotel.v2soru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.entity.FoodItems;
import com.hotel.v2soru.service.FoodItemService;

public class FoodItemController 
{
	@Autowired
	private FoodItemService foodItemService;
	
	@GetMapping("find")
	public ResponseEntity<ResponseStructure<FoodItems>> findFoodItem(@RequestParam long foodItemId){
		
		return foodItemService.findFoodItem(foodItemId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<FoodItems>>> findAllFoodItem(){
		
		return foodItemService.findAllFoodItem();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<FoodItems>> saveFoodItem(@RequestBody FoodItems foodItem){
		
		return foodItemService.saveFoodItem(foodItem);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<FoodItems>> updateFoodItem(@RequestParam long foodItemId,@RequestBody FoodItems foodItem){
		
		return foodItemService.updateFoodItem(foodItemId, foodItem);
	}
	
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<FoodItems>> dleteFoodItem(@RequestParam long foodItemId){
		
		return foodItemService.deleteFoodItem(foodItemId);
	}

}
