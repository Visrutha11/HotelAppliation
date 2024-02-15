package com.hotel.v2soru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dto.UserDto;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.service.UserService;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;

	@GetMapping("find")
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam long userId) {

		return userService.findUser(userId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUser(){
		
		return userService.findAllUser();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user){
		
		return userService.saveUser(user);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestParam long userId, @RequestBody User user){
		
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam long userId){
		
		return userService.deleteUser(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
