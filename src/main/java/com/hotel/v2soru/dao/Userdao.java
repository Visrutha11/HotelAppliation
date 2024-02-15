package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.repository.UserRepo;

public class Userdao 
{

	
	@Autowired
	private UserRepo userRepo;
	
	
	public User findUser(long userId) {
		
	Optional<User> user = userRepo.findById(userId);
	if(user.isPresent()) {
		return userRepo.findById(userId).get();
	}
	return null;	
	}
	
	public List<User> findAllUser() {
		
		return userRepo.findAll();
	}
	
	public User saveUser(User user) {
		
		return userRepo.save(user);
		
	}
	
	public User updateUser(long userId , User user) {
		
		User exuser = findUser(userId);
		if(exuser.getUserId() == userId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(user, exuser);
		return userRepo.save(exuser);
		}
		return null;
	}
	
	public User deleteUser(long userId) {
		User user = findUser(userId);
		if(user.getUserId() == userId) {
		userRepo.deleteById(userId);
		return user;
		}
		return null;
		
	}

}