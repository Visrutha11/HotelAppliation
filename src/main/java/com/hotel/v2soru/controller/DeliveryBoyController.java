package com.hotel.v2soru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.v2soru.config.ResponseStructure;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.service.DeliveryboyService;

public class DeliveryBoyController 
{
	@Autowired
	private DeliveryboyService deliveryBoyService;

	@GetMapping("find")
	public ResponseEntity<ResponseStructure<DeliveryBoy>> findDeliveryBoy(@RequestParam long deliveryBoyId){
		
		return deliveryBoyService.findDeliveryBoy(deliveryBoyId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<ResponseStructure<List<DeliveryBoy>>> findAllDeliveryBoy(){
		
		return deliveryBoyService.findAllDeliveyBoy();
	}
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<DeliveryBoy>> saveDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy){
		
		return deliveryBoyService.saveDeliveryBoy(deliveryBoy);
	}
	
	@PutMapping("update")
	public ResponseEntity<ResponseStructure<DeliveryBoy>> updateDeliveryBoy(@RequestParam long deliveryBoyId,@RequestBody DeliveryBoy deliveryBoy)
	{	
		return deliveryBoyService.updateDeliveryBoy(deliveryBoyId, deliveryBoy);
	}

	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<DeliveryBoy>> deleteDeliveryBoy(@RequestParam long deliveryBoyId){
		
		return deliveryBoyService.deleteDeliveryBoy(deliveryBoyId);
	}
	
}
