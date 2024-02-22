package com.hotel.v2soru.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dao.Admindao;
import com.hotel.v2soru.dao.DeliveryBoyDao;
import com.hotel.v2soru.dao.FoodOrderDao;
import com.hotel.v2soru.dao.Userdao;
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.dto.DeliveryBoyDto;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.entity.FoodOrders;
import com.hotel.v2soru.entity.OrderStatus;
import com.hotel.v2soru.entity.User;

@Service
public class AdminService 
{ 	
	@Autowired
	private Admindao adminDao;

	@Autowired
	private Userdao userDao;
	
	@Autowired
	private DeliveryBoyDao deliveryBoyDao;
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(long adminId) {
		com.hotel.v2soru.entity.Admin admin = adminDao.findAdmin(adminId);
		if (admin != null) {
			
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setMessages("Admin Found");
			structure.setStatuscode(HttpStatus.FOUND.value());
			structure.setData(admin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> findAlllAdmin() 
	{
			List<Admin> allAdmin= Admindao.findAllAdmin();
			if (!allAdmin.isEmpty())
			{
				
				ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
				structure.setMessages("Admin List Found");
				structure.setStatuscode(HttpStatus.FOUND.value());
				structure.setData(allAdmin);
				return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.FOUND);
			}
			return null;
	
	}
		

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {

		AdminDto adminDto = new AdminDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(adminDao.saveAdmin(admin), adminDto);

		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		structure.setMessages("Admin Created SuccessFully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setData(adminDto);

		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(long adminId, Admin admin) {
		Admin exadmin = adminDao.findAdmin(adminId);
		if (exadmin != null) {
		
			ModelMapper mapper = new ModelMapper();
			AdminDto adminDto = mapper.map(exadmin,AdminDto.class);

			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			structure.setMessages("Admin update successfully");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(adminDto);

			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}

		return null;
	   }

	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(long adminId) 
	{
		Admin admin = adminDao.findAdmin(adminId);
		if (admin != null) {
			AdminDto adminDto = new AdminDto();
			ModelMapper mapper = new ModelMapper();
			mapper.map(adminDao.deleteAdmin(adminId), adminDto);

			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			structure.setMessages("Admin deleted successfully");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(adminDto);

			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}

		return null;
	}
	
	public ResponseEntity<ResponseStructure<Admin>>assignUser(long adminId,long userId){
		
		Admin admin = adminDao.findAdmin(adminId);
		User user = userDao.findUser(userId);
		if(admin !=null && user != null) {
			admin.getManagedUsers().add(user);
			Admin updateAdmin = adminDao.updateAdmin(adminId, admin);
			
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setMessages("user assigned");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(updateAdmin);
			
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		
      return null;
	}
	
public ResponseEntity<ResponseStructure<Admin>>assignDeliveryBoy(long adminId,long deliveryBoyId){
		
	     Admin admin = adminDao.findAdmin(adminId);
		DeliveryBoy deliveryBoy = deliveryBoyDao.findDeliveryBoy(deliveryBoyId);
		if(admin !=null && deliveryBoy != null) {
			admin.getManagedDeliveryBoys();
			Admin updateAdmin = adminDao.updateAdmin(adminId, admin);
			
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setMessages("deliveryboy assigned");
			structure.setStatuscode(HttpStatus.OK.value());
			structure.setData(updateAdmin);
			
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		
		throw null;
	}

public ResponseEntity<ResponseStructure<List<FoodOrders>>> orderStatus(OrderStatus orderStatus){
	   
	   
	   System.out.println(orderStatus);
	    List<FoodOrders> allFoodOrder = foodOrderDao.findAllFoodOrder();
	    
	            List<OrderStatus> allOrderStatus = allFoodOrder.stream()
	            .map(FoodOrders::getOrderStatus)
	            .collect(Collectors.toList());
	    
	    List<FoodOrders> orders = null;
	    System.out.println(allOrderStatus);  
	   
	    switch (orderStatus) {
     case ORDERPROCESS:
         orders = allFoodOrder.stream()
                 .filter(order -> order.getOrderStatus() == OrderStatus.ORDERPROCESS)
                 .collect(Collectors.toList());
         System.out.println(orders);
         break; 
     
     case ORDERPENDING:
         orders = allFoodOrder.stream()
                 .filter(order -> order.getOrderStatus() == OrderStatus.ORDERPENDING)
                 .collect(Collectors.toList());
         System.out.println(orders);
         break;
         
     case ORDERCANCEL:
         orders = allFoodOrder.stream()
                 .filter(order -> order.getOrderStatus() == OrderStatus.ORDERCANCEL)
                 .collect(Collectors.toList());
         System.out.println(orders);
         break;
 }  
	   ResponseStructure<List<FoodOrders>> structure = new ResponseStructure<List<FoodOrders>>();
	   structure.setData(orders);
	   structure.setMessages("All FoodOrder Status");
	   structure.setStatuscode(HttpStatus.OK.value());
	   
	return new ResponseEntity<ResponseStructure<List<FoodOrders>>>(structure,HttpStatus.OK);
	
}
public ResponseEntity<ResponseStructure<DeliveryBoyDto>> assignUserToDeliveryBoy(long userId, long deliveryBoyId) {
    User user = userDao.findUser(userId);
    DeliveryBoy deliveryBoy = deliveryBoyDao.findDeliveryBoy(deliveryBoyId);

    if (user != null && deliveryBoy != null) {
        FoodOrders foodOrder = foodOrderDao.findFoodOrder(user.getUserId());
        foodOrder.setItems(null);
        foodOrderDao.saveFoodOrder(foodOrder);

        user.setDeliverBoy(deliveryBoy);
        userDao.updateUser(userId, user);

        deliveryBoy.setUser(user);

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        DeliveryBoyDto deliveryBoyDto = mapper.map(deliveryBoyDao.updateDeliveryBoy(deliveryBoyId, deliveryBoy), DeliveryBoyDto.class);

        ResponseStructure<DeliveryBoyDto> structure = new ResponseStructure<>();
        structure.setMessages("Delivery boy assigned");
        structure.setStatuscode(HttpStatus.OK.value());
        structure.setData(deliveryBoyDto);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

  return null;
}

   public ResponseEntity<ResponseStructure<Admin>> loginAdmin(Admin admin) {

	    Admin byAdminEmail = adminDao.findByadminEmail(admin.getAdminEmail());

	    if (admin.getAdminEmail() != null && byAdminEmail != null) {
	        
	        if (admin.getAdminEmail().equals(byAdminEmail.getAdminEmail()) &&
	            admin.getAdminPassword().equals(byAdminEmail.getAdminPassword())) {

	            ResponseStructure<Admin> structure = new ResponseStructure<>();
	            structure.setData(byAdminEmail);
	            structure.setMessages("Login successfully");
	            structure.setStatuscode(HttpStatus.OK.value());

	            return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
	        }
	    }
	   
	    ResponseStructure<Admin> errorStructure = new ResponseStructure<>();
	    errorStructure.setMessages("Login failed");
	    errorStructure.setStatuscode(HttpStatus.UNAUTHORIZED.value());

	    return new ResponseEntity<ResponseStructure<Admin>>(errorStructure, HttpStatus.UNAUTHORIZED);
	}
	
	
	
}