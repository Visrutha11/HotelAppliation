package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.repository.DeliveryBoyRepo;

public class DeliveryBoyDao 
{
	@Autowired
    DeliveryBoyRepo deliveryboyrepo;
	
	
	@Autowired
	private DeliveryBoyRepo deliveryBoyRepo;
	
	public DeliveryBoy findDeliveryBoy(long deliveryBoyId) {
		Optional<DeliveryBoy> deliveryboyid = deliveryBoyRepo.findById(deliveryBoyId);
		if(deliveryboyid.isPresent()) {
			return deliveryBoyRepo.findById(deliveryBoyId).get();
		}
		return null;
	}
	
	public List<DeliveryBoy> findAllDeliveryBoy() {
		return deliveryBoyRepo.findAll();
	}
	
	public DeliveryBoy saveDeliveryBoy(DeliveryBoy deliveryBoy) {
		
		return deliveryBoyRepo.save(deliveryBoy);
	}
	
	public DeliveryBoy updateDeliveryBoy(long deliveryBoyId, DeliveryBoy deliveryBoy) {
		
		DeliveryBoy exdeliveryBoy = findDeliveryBoy(deliveryBoyId);
		
		if(exdeliveryBoy.getDeliverBoyId() == deliveryBoyId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(deliveryBoy, exdeliveryBoy);
		deliveryBoyRepo.save(exdeliveryBoy);
		
		return exdeliveryBoy;
		}
		return null;
	}
	
	public DeliveryBoy deleteDeliveryBoy(long deliveryBoyId){
		
		DeliveryBoy deliveryboy = findDeliveryBoy(deliveryBoyId);
		if(deliveryboy == null) {
			deliveryBoyRepo.deleteById(deliveryBoyId);
			return deliveryboy;
		}
		return null;
	}
}
	
	
	
    


