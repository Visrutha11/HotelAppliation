package com.hotel.v2soru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.v2soru.entity.User;

public interface UserRepo extends JpaRepository<User, Long>
{
	@Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
	User findoneByuserEmail(String userEmail);
}
