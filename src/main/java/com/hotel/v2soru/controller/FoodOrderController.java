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
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.service.FoodORderService;

public class FoodOrderController
{
	@Autowired
	private FoodORderService foodOrderService;
	
	@GetMapping("find")
	public ResponseEntity<ResponseStructure<FoodOrders>> findFoodOrder(@RequestParam long foodOrderId){
		
		return foodOrderService.findFoodOrder(foodOrderId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<FoodOrders>>> findAllFoodOrder(){
		
		return foodOrderService.findAllFoodOrder();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<FoodOrders>> saveFoodOrder(@RequestBody FoodOrders foodOrder){
		
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<FoodOrders>> updateFoodOrder(@RequestParam long foodOrderId,@RequestBody FoodOrders foodOrder)
	{	
		return foodOrderService.updateFoodOrder(foodOrderId, foodOrder);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<FoodOrders>> deleteFoodOrder(@RequestParam long foodOrderId)
	{	
		return foodOrderService.deleteFoodOrder(foodOrderId);
	}
	@PutMapping("assignItem")
	public ResponseEntity<ResponseStructure<FoodOrders>> aasignFoodItem(@RequestParam long foodOrderId,@RequestParam long foodItemId){
		
		return foodOrderService.aasignFoodItem(foodOrderId, foodItemId);
	}
	
	@PutMapping("removeItem")
	 public ResponseEntity<ResponseStructure<FoodOrders>> removeFoodItem(@RequestParam long foodOrderId,@RequestParam long foodItemId){
		 
		 return foodOrderService.removeFoodItem(foodOrderId, foodItemId);
	 }

}
