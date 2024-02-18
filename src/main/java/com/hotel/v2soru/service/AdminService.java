package com.hotel.v2soru.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.controller.AdminController;
import com.hotel.v2soru.dao.Admindao;
import com.hotel.v2soru.dao.DeliveryBoyDao;
import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.dao.Userdao;
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.User;
import com.hotel.v2soru.exception.Usernotfound;

import jakarta.transaction.Status;
@Service
public class AdminService 
{ 	
	@Autowired
	private Admindao adminDao;
	
     public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(long adminId)
     {
		Admin admin = adminDao.findAdmin(adminId);
		if(admin != null)
		{
			AdminDto adminDto = new AdminDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(admin,adminDto);
			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			structure.setMessages("Admin Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(adminDto);
			
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
     
     public ResponseEntity<ResponseStructure<List<AdminDto>>> findAlllAdmin(){
    	 
    	 List<Admin> allAdmin = adminDao.findAllAdmin();
    	 if(!allAdmin.isEmpty()) {
    		 List<AdminDto> adminDto = new ArrayList<AdminDto>();
    		 ModelMapper mapper = new ModelMapper();
    		 for(Admin adminlist : allAdmin) {
    			 adminDto.add(mapper.map(adminlist, AdminDto.class));
    		 }
    		 ResponseStructure<List<AdminDto>> structure = new ResponseStructure<List<AdminDto>>();
    		 structure.setMessages("Admin List Found");
    		 structure.setStatuscode(HttpStatus.FOUND.value());
    		 structure.setData(adminDto);
    		return new ResponseEntity<ResponseStructure<List<AdminDto>>>(structure,HttpStatus.FOUND); 
    	 }
    	 return null; // throw admin list not found
     }
     
     public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin){
    	 
    	 AdminDto adminDto = new AdminDto();
    	 ModelMapper mapper = new ModelMapper();
    	 mapper.map(adminDao.saveadmin(admin), adminDto);
    	 
    	 ResponseStructure<AdminDto> structure = new  ResponseStructure<AdminDto>();
    	 structure.setMessages("Admin Created SuccessFully");
    	 structure.setStatuscode(HttpStatus.CREATED.value());
    	 structure.setData(adminDto);
    	 
    	 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
     }
     
     public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(long adminId, Admin admin){
    	 Admin exadmin = adminDao.findAdmin(adminId);
    	 if(exadmin != null) {
    		 AdminDto adminDto = new AdminDto();
    		 ModelMapper mapper = new ModelMapper();
    		 mapper.map(adminDao.updateAdmin(adminId, admin),adminDto);
    		 
    		 ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
    		 structure.setMessages("Admin update successfully");
    		 structure.setStatuscode(HttpStatus.OK.value());
    		 structure.setData(adminDto);
    		 
    		 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
    	 }
    	 
    	 return null;//throw  admin does not exist
     }
     
     public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(long adminId){
    	 Admin admin = adminDao.findAdmin(adminId);
    	 if(admin != null) {
    		 AdminDto adminDto = new AdminDto();
    		 ModelMapper mapper = new ModelMapper();
    		 mapper.map(adminDao.deleteAdmin(adminId), adminDto);
    		 
    		 ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
    		 structure.setMessages("Admin deleted successfully");
    		 structure.setStatuscode(HttpStatus.OK.value());
    		 structure.setData(adminDto);
    		 
    		 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
    	 }
    	 
    	 return null; //throw admin does not exist
     }
     
     public ResponseEntity<ResponseStructure<Admin>>assingnuser(long adminId,long userId)
     {
	    Admin admin=adminDao.findAdmin(adminId);
	    User user=Userdao.findUser(userId);
	    if(admin!=null&&user!=null)
	    {
	    	admin.getManageusers().add(user);
	    	Admin updateAdmin=adminDao.updateAdmin(adminId, admin);
	    	
	    	ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
	    	structure.setMessages("user assigned");
	    	structure.setStatuscode(HttpStatus.OK.value());
	    	structure.setData(updateAdmin);
	    	
	    	return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
	    }
     }
     public ResponseEntity<ResponseStructure<Admin>> assignDeliveryBoy(long adminId,long deliveryBoyId){
 		
 		Admin admin = adminDao.findAdmin(adminId);
 		DeliveryBoy deliveryBoy = DeliveryBoyDao.findDeliveryBoy(deliveryBoyId);
 		if(admin !=null && deliveryBoy != null) {
 			admin.getManagedDeliveryBoys().add(deliveryBoy);
 			Admin updateAdmin = adminDao.updateAdmin(adminId, admin);
 			
 			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
 			structure.setMessages("deliveryboy assigned");
 			structure.setStatuscode(HttpStatus.OK.value());
 			structure.setData(updateAdmin);
 			
 			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
 		}
 		
 		throw new Exception("DeliveyBoy Not Found");
 	}

    public ResponseEntity<ResponseStructure<List<FoodOrders>>> orderStatus(OrderStatus orderStatus)
    {     
 	   System.out.println(orderStatus);
 	    List<FoodOrders> allFoodOrder = FoodOrderDao.findAllFoodOrder();
 	    
 	    List<OrderStatus> allOrderStatus = allFoodOrder.stream()
 	            .map(FoodOrders::getOrderStatus)
 	            .collect(Collectors.toList());
 	    
 	    List<FoodOrder> orders = null;
 	    System.out.println(allOrderStatus);  
 	   
 	    switch (orderStatus) {
         case ORDER_PROCESS:
             orders = allFoodOrder.stream()
                     .filter(order -> order.getOrderStatus() == OrderStatus.ORDER_PROCESS)
                     .collect(Collectors.toList());
             System.out.println(orders);
             break; 
         
         case ORDER_PENDING:
             orders = allFoodOrder.stream()
                     .filter(order -> order.getOrderStatus() == OrderStatus.ORDER_PENDING)
                     .collect(Collectors.toList());
             System.out.println(orders);
             break;
             
         case ORDER_CANCEL:
             orders = allFoodOrder.stream()
                     .filter(order -> order.getOrderStatus() == OrderStatus.ORDER_CANCEL)
                     .collect(Collectors.toList());
             System.out.println(orders);
             break;
     }
 	   
 	   ResponseStructure<List<FoodOrder>> structure = new ResponseStructure<List<FoodOrder>>();
 	   structure.setData(orders);
 	   structure.setMessage("All FoodOrder Status");
 	   structure.setStatusCode(HttpStatus.OK.value());
 	   
 	return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure,HttpStatus.OK);
 	
 }
    public ResponseEntity<ResponseStructure<DeliveryBoyDto>> assignUserToDeliveryBoy(long userId, long deliveryBoyId) {
 	    User user = userDao.findUser(userId);
 	    DeliveryBoy deliveryBoy = deliveryBoyDao.findDeliveryBoy(deliveryBoyId);

 	    if (user != null && deliveryBoy != null) {
 	        FoodOrder foodOrder = foodOrderDao.findFoodOrder(user.getUserId());
 	        foodOrder.setItems(null);
 	        foodOrderDao.saveFoodOrder(foodOrder);

 	        user.setDeliverBoy(deliveryBoy);
 	        userDao.updateUser(userId, user);

 	        deliveryBoy.setUser(user);
 	
 	        ModelMapper mapper = new ModelMapper();
 	        mapper.getConfiguration().setAmbiguityIgnored(true);
 	        DeliveryBoyDto deliveryBoyDto = mapper.map(deliveryBoyDao.updateDeliveryBoy(deliveryBoyId, deliveryBoy), DeliveryBoyDto.class);

 	        ResponseStructure<DeliveryBoyDto> structure = new ResponseStructure<>();
 	        structure.setMessage("Delivery boy assigned");
 	        structure.setStatusCode(HttpStatus.OK.value());
 	        structure.setData(deliveryBoyDto);
 	        return new ResponseEntity<>(structure, HttpStatus.OK);
 	    }

 	    throw new UserNotFoundException("User does not exist");
 	}

    public ResponseEntity<ResponseStructure<Admin>> loginAdmin(Admin admin) {

 	    Admin byAdminEmail = adminDao.findByadminEmail(admin.getAdminEmail());

 	    if (admin.getAdminEmail() != null && byAdminEmail != null) {
 	        
 	        if (admin.getAdminEmail().equals(byAdminEmail.getAdminEmail()) &&
 	            admin.getAdminPassword().equals(byAdminEmail.getAdminPassword())) {

 	            ResponseStructure<Admin> structure = new ResponseStructure<>();
 	            structure.setData(byAdminEmail);
 	            structure.setMessage("Login successfully");
 	            structure.setStatusCode(HttpStatus.OK.value());

 	            return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
 	        }
 	    }
 	   
 	    ResponseStructure<Admin> errorStructure = new ResponseStructure<>();
 	    errorStructure.setMessage("Login failed");
 	    errorStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());

 	    return new ResponseEntity<ResponseStructure<Admin>>(errorStructure, HttpStatus.UNAUTHORIZED);
 	} 
     
  
     
     
  	    
  	  
     
     
   

}
        
}
}