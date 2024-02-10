package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.v2soru.dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Getter@Setter
@Component
public class Adminentity 
{
	 private int adminId;
	    private String adminname;
	    private String adminemail;
	    @OneToMany
	    private List<Userentity> user;
	    @OneToMany
	    private List<Orders>order;
	    @OneToMany
	    private List<DeviveryBoy>deliverboy;
	   
	
}
