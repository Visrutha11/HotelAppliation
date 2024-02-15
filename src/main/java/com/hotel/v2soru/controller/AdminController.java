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
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.service.AdminService;


@RestController
@RequestMapping("Admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping("find")
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(@RequestParam long adminId)
	{
		return adminService.findAdmin(adminId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<AdminDto>>> findAllAdmin()
	{
		return adminService.findAlllAdmin();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin)
	{	
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestParam long adminId ,@RequestBody Admin admin)
	{		
	   return adminService.updateAdmin(adminId, admin);
	}

	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam long adminId)
	{	
		return adminService.deleteAdmin(adminId);
	}

}
