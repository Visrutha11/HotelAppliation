package com.hotel.v2soru.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.hotel.v2soru.dto.DeliveryBoyDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.OrderStatus;
import com.hotel.v2soru.service.AdminService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping("find")
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(@RequestParam long adminId){
		return adminService.findAdmin(adminId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin(){
		return adminService.findAlllAdmin();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@Valid @RequestBody Admin admin, BindingResult result){
		
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestParam long adminId ,@RequestBody Admin admin){
		
		return adminService.updateAdmin(adminId, admin);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam long adminId){
		
		return adminService.deleteAdmin(adminId);
	}
	
	@PutMapping("assignUser")
	public ResponseEntity<ResponseStructure<Admin>> assignUser(@RequestParam long adminId, @RequestParam long userId){
		
		return adminService.assignUser(adminId, userId);
	}
	
	@PutMapping("assignDeliveryBoy")
	public ResponseEntity<ResponseStructure<Admin>> assignDeliveryBoy(@RequestParam long adminId,@RequestParam long deliveryBoyId){
		
		return adminService.assignDeliveryBoy(adminId, deliveryBoyId);
	}
	
	@GetMapping("findOrderStatus")
	public ResponseEntity<ResponseStructure<List<FoodOrders>>> orderStatus(@RequestParam OrderStatus orderStatus){
		
		return adminService.orderStatus(orderStatus);
	}
	
	@PutMapping("assignUserToDeliveryBoy")
	public ResponseEntity<ResponseStructure<DeliveryBoyDto>> assignUserToDeliveryBoy(@RequestParam long userId,@RequestParam long deliveryBoyId){
		
		return adminService.assignUserToDeliveryBoy(userId, deliveryBoyId);
	}
	
	@PostMapping("adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> findByadminEmailAndadminPassword(@RequestBody Admin admin){
		
		 return adminService.loginAdmin(admin);
	 }
	
	
	
	
	
	

}