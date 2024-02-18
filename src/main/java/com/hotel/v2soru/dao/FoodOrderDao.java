package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.repository.FoodOrderRepo;
@Repository
public class FoodOrderDao
{

	@Autowired
	private FoodOrderRepo foodOrderRepo;
	
	public FoodOrders findFoodOrder(long foodOrderId) {
		
		Optional<FoodOrders> foodorder = foodOrderRepo.findById(foodOrderId);
		if(foodorder.isPresent()) {
			return foodOrderRepo.findById(foodOrderId).get();
		}
		return null;
	}
	
	public List<FoodOrders> findAllFoodOrder() {
		
		return foodOrderRepo.findAll();
	}
	
	public FoodOrders saveFoodOrder(FoodOrders foodOrder) {
		
		return foodOrderRepo.save(foodOrder);
		
	}
	
	public FoodOrders updateFoodOrder(long foodOrderId, FoodOrders foodOrder) {
		FoodOrders exFoodOrder = findFoodOrder(foodOrderId);
		if(exFoodOrder.getOrderId() == foodOrderId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(foodOrder , exFoodOrder);
		
		return exFoodOrder;
		}
		return null;
	}
	
	public FoodOrders deleteFoodOrder(long foodOrderId) {
		
		FoodOrders foodOrder = findFoodOrder(foodOrderId);
		if(foodOrder.getOrderId() == foodOrderId) {
			foodOrderRepo.deleteById(foodOrderId);
			return foodOrder;
		}
		return null;
		
	}
}
