package com.hotel.v2soru.dao;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.repository.AdminRepo;
@Repository
public class Admindao 
{
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin findAdmin(long adminId) {
		
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(admin.isPresent()) {
			return adminRepo.findById(adminId).get();
		}
		return null;
	}
	
	public List<Admin> findAllAdmin() {
		
		return adminRepo.findAll();
	}
	
	public Admin saveAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}
	
	public Admin updateAdmin(long adminId, Admin admin) {
		Admin exadmin = findAdmin(adminId);
		if(exadmin.getAdminId() == adminId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(admin, exadmin);
		adminRepo.save(exadmin);
		return exadmin;
		}
		return null;
	}
	
	public Admin deleteAdmin(long adminId) {
		Admin admin = findAdmin(adminId);
		if(admin.getAdminId() == adminId) {
			adminRepo.deleteById(adminId);
			return admin;
		}
		return null;
	}
	
	public Admin findByadminEmail(String adminEmail) {
		
		return adminRepo.findoneByadminEmail(adminEmail);
	}
	
	
      

	
	
	
	
	
	
	
	
	
}
