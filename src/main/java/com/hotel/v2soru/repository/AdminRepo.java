package com.hotel.v2soru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.v2soru.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>
{

	@Query("SELECT a FROM Admin a WHERE a.adminEmail = :adminEmail")
	Admin findoneByadminEmail(String adminEmail); 

	
	

}
