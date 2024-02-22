package com.hotel.v2soru.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dao.Userdao;
import com.hotel.v2soru.dto.UserDto;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.User;

import jakarta.transaction.Transactional;
@Service
public class UserService 
{
	
	@Autowired
	private Userdao userDao;
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(long userId){
		User user = userDao.findUser(userId);
		if(user != null) {
			UserDto userDto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(user , userDto);
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessages("User Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(userDto);
			
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.FOUND);
		}
		return null; // throw user id not found exception
	}
	
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUser(){
		
		List<User> allUser = userDao.findAllUser();
		
		if(!allUser.isEmpty()) {
			List<UserDto> userDto = new ArrayList<UserDto>();
			ModelMapper mapper = new ModelMapper();
			for(User list: allUser){
				userDto.add(mapper.map(list, UserDto.class));
			}
			ResponseStructure<List<UserDto>> structure = new ResponseStructure<List<UserDto>>();
			structure.setMessages("User List Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(userDto);
			
			return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure,HttpStatus.FOUND);
		}
		
		return null;// throw user list not found exception
		
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user){
		
		UserDto userDto = new UserDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(userDao.saveUser(user), userDto);
		
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		structure.setMessages("User created");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(userDto);
		
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(long userId,User user){
		
		User exuser = userDao.findUser(userId);
		if(exuser != null) {
			UserDto userDto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(userDao.updateUser(userId, user), userDto);
		
			
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessages("User Update SuccesFully");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(userDto);
			
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
			
		}
		
		return null; // throw user does not exist
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(long userId){
		User user = userDao.findUser(userId);
		if(user != null) {
			UserDto userDto = new UserDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(userDao.deleteUser(userId),userDto);
			ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
			structure.setMessages("User Deleted SuccessFully");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(userDto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		
		return null; // throw user id does not exist
	}
	@Transactional
	public ResponseEntity<ResponseStructure<User>> assignOreder(long userId, long foodOrderId) {

		User user = userDao.findUser(userId);
		FoodOrders foodOrder = new FoodOrders();

		if (user != null ){
			
			 user.getFoodOrders().add(foodOrder);
			 User updateUser = userDao.updateUser(userId, user);
			 
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setData(updateUser );
			structure.setMessages("oredr assigned");
			structure.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);		
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<User>> userLogin(User user) {
		 User byUserEmail = userDao.userlogin(user.getUserEmail());

		    if (user.getUserEmail() != null && byUserEmail != null) {
		        
		        if (user.getUserEmail().equals(byUserEmail.getUserEmail()) &&
		            user.getUserPassword().equals(byUserEmail.getUserPassword())) {

		            ResponseStructure<User> structure = new ResponseStructure<User>();
		          
		            structure.setMessages("Login successfully");
		            structure.setStatuscode(HttpStatus.OK.value());
		            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		        }
		    }
		    ResponseStructure<User> errorStructure = new ResponseStructure<User>();
		    errorStructure.setMessages("Login failed");
		    errorStructure.setStatuscode(HttpStatus.UNAUTHORIZED.value());

		    return new ResponseEntity<ResponseStructure<User>>(errorStructure, HttpStatus.UNAUTHORIZED);
		}

	
	
	
	
	
	
	
	
	
	
	

}
