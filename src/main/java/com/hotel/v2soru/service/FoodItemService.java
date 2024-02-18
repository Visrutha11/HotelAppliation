package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dao.FoodItemDao;
import com.hotel.v2soru.entity.FoodItems;
@Service
public class FoodItemService 
{
	@Autowired
private FoodItemDao foodItemDao;
	
	public ResponseEntity<ResponseStructure<FoodItems>> findFoodItem(long foodItem){
		
		FoodItems exfoodItem = foodItemDao.findFoodItem(foodItem);
		if(exfoodItem != null) {
			ResponseStructure<FoodItems> structure = new ResponseStructure<FoodItems>();
			structure.setMessages("Food Item Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(foodItemDao.findFoodItem(foodItem));
			
			return new ResponseEntity<ResponseStructure<FoodItems>>(structure,HttpStatus.FOUND);
		}
		
		return null; //throw food item does not exist
	}
	
	public ResponseEntity<ResponseStructure<List<FoodItems>>> findAllFoodItem(){
		
		List<FoodItems> allFoodItem = foodItemDao.findAllFoodItem();
		if(!allFoodItem.isEmpty()) {
			
			ResponseStructure<List<FoodItems>> structure = new ResponseStructure<List<FoodItems>>();
			structure.setMessages("FoodItem List Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(foodItemDao.findAllFoodItem());
			
			return new ResponseEntity<ResponseStructure<List<FoodItems>>>(structure,HttpStatus.FOUND);
		}
		
		return null; // throw fooditem list not found
	}
	
	public ResponseEntity<ResponseStructure<FoodItems>> saveFoodItem(FoodItems foodItem){
		
		ResponseStructure<FoodItems> structure = new ResponseStructure<FoodItems>();
		structure.setMessages("FoodItem saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(foodItemDao.saveFoodItem(foodItem));
		
		return new ResponseEntity<ResponseStructure<FoodItems>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<FoodItems>> updateFoodItem(long foodItemId,FoodItems foodItem){
		 FoodItems exfoodItem = foodItemDao.findFoodItem(foodItemId);
		 if(foodItem != null) {
			 ResponseStructure<FoodItems> structure = new ResponseStructure<FoodItems>();
			 structure.setMessages("FoodItem Updated");
			 structure.setStatuscode(HttpStatus.OK.value());
			 structure.setData(foodItemDao.updateFoodItem(foodItemId, foodItem));
			 
			 return new ResponseEntity<ResponseStructure<FoodItems>>(structure,HttpStatus.OK);
			 
		 }
		
		return null; //throw food item does not exist
	}
	
	public ResponseEntity<ResponseStructure<FoodItems>> deleteFoodItem(long foodItemId){
		FoodItems foodItem = foodItemDao.findFoodItem(foodItemId);
		if(foodItem != null) {
			ResponseStructure<FoodItems> structure = new ResponseStructure<FoodItems>();
			structure.setMessages("FoodItem deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(foodItemDao.deleteFoodItem(foodItemId));
			
			return new ResponseEntity<ResponseStructure<FoodItems>>(structure,HttpStatus.OK);
		}
		return null; // throw fooditem does not exist
	}
}
