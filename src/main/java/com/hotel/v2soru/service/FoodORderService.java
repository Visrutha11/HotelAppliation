package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.entity.FoodOrders;
@Service
public class FoodORderService 
{
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	 public ResponseEntity<ResponseStructure<FoodOrders>> findFoodOrder(long foodOrderId){
		 
		 FoodOrders foodOrder = foodOrderDao.findFoodOrder(foodOrderId);
		 if(foodOrder != null) {
			 ResponseStructure<FoodOrders> structure = new ResponseStructure<FoodOrders>();
			 structure.setMessages("Food Order Found");
			 structure.setStatuscode(HttpStatus.FOUND.value());
			 structure.setData(foodOrderDao.findFoodOrder(foodOrderId));
			 
			 return new ResponseEntity<ResponseStructure<FoodOrders>>(structure,HttpStatus.FOUND);
		 }
		 return null; // throw food order does not exist
	 }
	 
	 public ResponseEntity<ResponseStructure<List<FoodOrders>>> findAllFoodOrder(){
		 List<FoodOrders> exfoodOrder = foodOrderDao.findAllFoodOrder();
		 if(!exfoodOrder.isEmpty()) {
			 ResponseStructure<List<FoodOrders>> structure = new ResponseStructure<List<FoodOrders>>();
			 structure.setMessages("FoodOrder List Found");
			 structure.setStatuscode(HttpStatus.FOUND.value());
			 structure.setData(foodOrderDao.findAllFoodOrder());
			 
			 return new ResponseEntity<ResponseStructure<List<FoodOrders>>>(structure,HttpStatus.FOUND);
		 }
		 
		 return null; // throw foodorder list not found
	 }
	 
	 public ResponseEntity<ResponseStructure<FoodOrders>> saveFoodOrder(FoodOrders foodOrder){
		 
		 ResponseStructure<FoodOrders> structure = new ResponseStructure<FoodOrders>();
		 structure.setMessages("FoodOrder saved");
		 structure.setStatuscode(HttpStatus.CREATED.value());
		 structure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		 
		 return new ResponseEntity<ResponseStructure<FoodOrders>>(structure,HttpStatus.CREATED);
	 }
	 
	 public ResponseEntity<ResponseStructure<FoodOrders>> updateFoodOrder(long foodOrderId,FoodOrders foodOrder){
		 
		 FoodOrders exfoodOrder = foodOrderDao.findFoodOrder(foodOrderId);
		 if(exfoodOrder != null) {
			 ResponseStructure<FoodOrders> structure = new ResponseStructure<FoodOrders>();
			 structure.setMessages("Food Order Updated");
			 structure.setStatuscode(HttpStatus.OK.value());
			 structure.setData(foodOrderDao.updateFoodOrder(foodOrderId, foodOrder));
			 
			 return new ResponseEntity<ResponseStructure<FoodOrders>>(structure,HttpStatus.OK);
		 }
		 
		 return null;// throw food order does not exist
	 }
	 
	 public ResponseEntity<ResponseStructure<FoodOrders>> deleteFoodOrder(long foodOrderId){
		 
		 FoodOrders foodOrder = foodOrderDao.findFoodOrder(foodOrderId);
		 if(foodOrder != null) {
			 ResponseStructure<FoodOrders> structure = new ResponseStructure<FoodOrders>();
			 structure.setMessages("Food Order Deleted");
			 structure.setStatuscode(HttpStatus.OK.value());
			 structure.setData(foodOrderDao.deleteFoodOrder(foodOrderId));
			 
			 return new ResponseEntity<ResponseStructure<FoodOrders>>(structure,HttpStatus.OK);
		 }

		 return null; //food order does not exist
	 }
}
