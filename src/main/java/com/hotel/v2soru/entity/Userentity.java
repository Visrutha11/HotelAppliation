package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component

public class Userentity 
{
	 private int userId;
	    private String username;
	    private String email;
	    private String password;
	    private List<Orders> orders;
}
