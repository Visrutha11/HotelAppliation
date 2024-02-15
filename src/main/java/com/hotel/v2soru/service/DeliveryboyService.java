package com.hotel.v2soru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.dao.DeliveryBoyDao;
import com.hotel.v2soru.entity.DeliveryBoy;

public class DeliveryboyService 
{
     @Autowired
     private DeliveryBoyDao deliveryBoyDao;
     
     public ResponseEntity<ResponseStructure<DeliveryBoy>> findDeliveryBoy(long deliveryBoyId){
 		DeliveryBoy deliveryBoy = deliveryBoyDao.findDeliveryBoy(deliveryBoyId);
 		if(deliveryBoy != null) 
 		{
 			ResponseStructure<DeliveryBoy> structure = new ResponseStructure<DeliveryBoy>();
 			structure.setMessages("DeliveryBoy found");
 			structure.setStatuscode(HttpStatus.FOUND.value());
 			structure.setData(deliveryBoyDao.findDeliveryBoy(deliveryBoyId));
 			
 			return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.FOUND);
 		}
 		
 		return null; //throw deliveryBoy does not Exist
 	}
 	
 	public ResponseEntity<ResponseStructure<List<DeliveryBoy>>> findAllDeliveyBoy(){
 		List<DeliveryBoy> allDeliveryBoy = deliveryBoyDao.findAllDeliveryBoy();
 		if(!allDeliveryBoy.isEmpty()) {
 			ResponseStructure<List<DeliveryBoy>> structure = new ResponseStructure<List<DeliveryBoy>>();
 			structure.setMessages("DeliverBoy List Found");
 			structure.setStatuscode(HttpStatus.FOUND.value());
 			structure.setData(deliveryBoyDao.findAllDeliveryBoy());
 			
 			return new ResponseEntity<ResponseStructure<List<DeliveryBoy>>>(structure,HttpStatus.FOUND);
 		}
 		return null; //throw deliverboy list not found
 	}
 	
 	public ResponseEntity<ResponseStructure<DeliveryBoy>> saveDeliveryBoy(DeliveryBoy deliveryBoy){
 		  ResponseStructure<DeliveryBoy> structure = new ResponseStructure<DeliveryBoy>();
 		  structure.setMessages("DeliveryBoy saved");
 		  structure.setStatuscode(HttpStatus.CREATED.value());
 		  structure.setData(deliveryBoyDao.saveDeliveryBoy(deliveryBoy));
 		
 		return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.CREATED);
 	}
 	
 	public ResponseEntity<ResponseStructure<DeliveryBoy>> updateDeliveryBoy(long deliverBoyId, DeliveryBoy deliveryBoy){
 		  DeliveryBoy exdeliveryBoy = deliveryBoyDao.findDeliveryBoy(deliverBoyId);
 		  if(exdeliveryBoy != null) {
 			  ResponseStructure<DeliveryBoy> structure = new ResponseStructure<DeliveryBoy>();
 			  structure.setMessages("DeliveryBoy Updated");
 			  structure.setStatuscode(HttpStatus.OK.value());
 			  structure.setData(deliveryBoyDao.updateDeliveryBoy(deliverBoyId, deliveryBoy));
 			  
 			  return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.OK);
 		  }
		return null;
 	}
 	
 	public ResponseEntity<ResponseStructure<DeliveryBoy>> deleteDeliveryBoy(long deliveryBoyId){
		  DeliveryBoy deliveryBoy = deliveryBoyDao.findDeliveryBoy(deliveryBoyId);
		  if(deliveryBoy != null) {
			  ResponseStructure<DeliveryBoy> structure = new ResponseStructure<DeliveryBoy>();
			  structure.setMessages("DeliveryBoy deleted");
			  structure.setStatuscode(HttpStatus.OK.value());
			  structure.setData(deliveryBoyDao.deleteDeliveryBoy(deliveryBoyId));
			  
			  return new ResponseEntity<ResponseStructure<DeliveryBoy>>(structure,HttpStatus.OK);
		  }
		
		return null; //throw deliveryboy does not exist
	}

 	
 	
}
