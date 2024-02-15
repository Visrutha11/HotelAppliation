package com.hotel.v2soru.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.controller.AdminController;
import com.hotel.v2soru.dao.Admindao;
import com.hotel.v2soru.dto.AdminDto;
import com.hotel.v2soru.entity.Admin;

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
		return null;// throw new admin does not exist exception
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

        
}
