package com.hotel.v2soru.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.v2soru.config.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice

public class GlobalExceptionHandler 
{

	@ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String,String> hashmap = new HashMap<String, String>();
		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessages("add proper details");
		structure.setStatuscode(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<Object>(structure,HttpStatus.BAD_REQUEST);
	}
	
	//User Exception
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> Usernotfound(Usernotfound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("User Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> UserListnotFound(UserListnotFound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("User List Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	//Admin Exceptions 
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> Adminnotfound(Adminnotfound ex){
		
		ResponseStructure<String> structure =new  ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("Admin Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AdminListnotFound(AdminListnotFound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("Admin List Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	//FoodOrder Exception
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> foodOrderNotFound(foodordernotofound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("FoodOrder Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> foodOrderListNotFound(FoodOrderListNotFound ex){
		 
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("FoodOrder List Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	//FoodItem Exception
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> FoodItemNotFound(FoodItemNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("FoodItem Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> FoodListItemsNotFound(FoodListItemsNotFound ex) {
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("FoodItem List Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	//DeliveryBoy Exception
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> DeliveryBoyNotFound(DeliveryBoynotfound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("DeliveryBoy Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> deliverryBoyListNotFound(DeliverryBoyListNotFound ex){
		
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessages("DeliveryBoy List Not Found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	
	}
}
