package com.hotel.v2soru.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hotel.v2soru.entity.DeliveryBoy;
import com.hotel.v2soru.repository.DeliveryBoyRepo;

@Repository
public class DeliveryBoyDao 
{
	@Autowired
    DeliveryBoyRepo deliveryboyrepo;

	public  DeliveryBoy findDeliveryBoy(long deliveryBoyId) 
	{
		Optional<DeliveryBoy> deliveryboyid = deliveryboyrepo.findById(deliveryBoyId);
		if(deliveryboyid.isPresent()) {
			return deliveryboyrepo.findById(deliveryBoyId).get();
		}
		return null;
	}
	
	public List<DeliveryBoy> findAllDeliveryBoy() {
		return deliveryboyrepo.findAll();
	}
	
	public DeliveryBoy saveDeliveryBoy(DeliveryBoy deliveryBoy) {
		
		return deliveryboyrepo.save(deliveryBoy);
	}
	
	public DeliveryBoy updateDeliveryBoy(long deliveryBoyId, DeliveryBoy deliveryBoy) {
		
		DeliveryBoy exdeliveryBoy = findDeliveryBoy(deliveryBoyId);
		
		if(exdeliveryBoy.getDeliveryBoyId() == deliveryBoyId) {
		ModelMapper mapper = new ModelMapper();
		mapper.map(deliveryBoy, exdeliveryBoy);
		deliveryboyrepo.save(exdeliveryBoy);
		
		return exdeliveryBoy;
		}
		return null;
	}
	
	public DeliveryBoy deleteDeliveryBoy(long deliveryBoyId){
		
		DeliveryBoy deliveryboy = findDeliveryBoy(deliveryBoyId);
		if(deliveryboy == null) {
			deliveryboyrepo.deleteById(deliveryBoyId);
			return deliveryboy;
		}
		return null;
	}
}
	
	
	
    


