package com.hotel.v2soru.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Getter
@Setter
public class User 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long userId;
	    @NotNull(message = "username cannot be null")
	    @NotBlank(message = "username cannot be blank")
	    private String userName;
	   
	    @NotNull(message = "email can not be null")
	    @NotBlank(message = "email can not be blank")
	    @Email(message = "Invalid Email",regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	    private String userEmail;
	    
	   
	    @NotBlank(message = "password cannot be blank")
	    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)",
	    message ="password must be alphanumeric and special characters" )
	    @Size(min = 8,max = 16, message = "password must be 8 to 16 characters")
	    private String userPassword;
	    
	    @Positive
	  
	    private long userContact;
	    
	    @NotBlank(message = "Address is required")
	    private String userAddress;
	   
	    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<FoodOrders> foodOrders;
		
	    
	    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
		private DeliveryBoy deliverBoy;

}
