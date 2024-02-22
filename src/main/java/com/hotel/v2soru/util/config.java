package com.hotel.v2soru.util;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

public class config 
{
	@Bean
	public OpenAPI swaggerDocOpenAPI() {
		Server devServer=new Server();
		devServer.setUrl("localhost:8080");
		devServer.setDescription("Developement Server");
		
		Server testServer=new Server();
		testServer.setUrl("localhost:8080");
		testServer.setDescription("TestServer");
		
		Contact co=new Contact();
		co.setEmail("visrutha33@gmail.com");
		co.setName("Visrutha");
		co.setUrl("../https://github.com");
		
		License ls=new License();
		ls.setName("License");
		ls.setUrl("License Provider");
		
		Info in=new Info();
		in.setContact(co);
		in.setLicense(ls);
		in.setDescription("HOTEL APPLICATION CREATED ");
		
		in.setTermsOfService("../Terms&con.html");
		in.setTitle("HOTEL APPLICATION");
		in.setVersion("1.0");
		
		OpenAPI op=new OpenAPI();
		op.info(in);
		op.servers(Arrays.asList(devServer,testServer));
		return op;
		
	}
}
