package com.hotel.v2soru.dao;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.hotel.v2soru.entity.Admin;
import com.hotel.v2soru.repository.AdminRepo;

public class Admindao 
{
	@Autowired
	private AdminRepo adminrepo;
	
	public Admin findAdmin(long adminid)
	{
		Optional<Admin>admin=adminrepo.findById(adminid);
		if(admin.isPresent())
		{
		return adminrepo.findById(adminid).get();
	}
		return null;
	}
	
	public List<Admin>findAllAdmin()
	{
		return adminrepo.findAll();
	}
	
	public Admin saveadmin(Admin admin)
	{
		return adminrepo.save(admin);
	}
	public Admin updateAdmin(long adminId,Admin admin)
	{
		Admin exadmin=findAdmin(adminId);
		if(exadmin.getAdminId()==adminId)
		{
			ModelMapper mapper=new ModelMapper();
			mapper.map(admin, exadmin);
			adminrepo.save(exadmin);
			return exadmin;
		}
		return null;
	}
	
	public Admin deleteAdmin(long adminId)
	{
		Admin admin=findAdmin(adminId);
		if(admin.getAdminId()==adminId)
		{
			adminrepo.deleteById(adminId);
			return admin;
		}
		return null;
	}
	
	
      

	
	
	
	
	
	
	
	
	
}
