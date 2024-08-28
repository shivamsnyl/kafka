package com.company.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.Customer;
import com.company.service.UserService;

@RestController
@RequestMapping("/location")
public class UserServiceController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/update")
	ResponseEntity<?> setLocation(){
		int i =0;
		while(i<100000) {
		service.updateLocation("(" +Math.round(Math.random()*100) +", " +Math.round(Math.random()*100) + ")");
		i++;
		}
		return new ResponseEntity<>(Map.of("message","location updated"),HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	ResponseEntity<?> customer(@RequestBody Customer c){
		service.customerSend(c);
		return new ResponseEntity<>(Map.of("Customer Sent",c),HttpStatus.OK);
	}

}
