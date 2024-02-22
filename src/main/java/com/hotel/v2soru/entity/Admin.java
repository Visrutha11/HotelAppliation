package com.hotel.v2soru.entity;


import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Admin 
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
   
    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
	private String adminName;
  
    @NotNull(message = "email can not be null")
    @NotBlank(message = "email can not be blank")
    @Email(message = "Invalid Email",regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String adminEmail;
	
    @NotNull(message = "password can not be null")
	@NotBlank(message = "password can not be blank")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)",
    message ="password must be alphanumeric and special characters" )
    @Size(min = 8,max = 16, message = "password must be 8 to 16 characters")
	private String adminPassword;
	
	@Positive
	private long adminContact;
	
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<User> managedUsers; // One-to-Many ->one admin many user
	
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<DeliveryBoy> managedDeliveryBoys;


}






	
