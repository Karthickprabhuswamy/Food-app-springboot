package com.ty.foodappservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody @Validated Customer customer) {
		
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/customer/{email}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmial(@PathVariable  String email) {
		
		return customerService.findCustomerByEmail(email);
	}
	@GetMapping("/customers/{phone}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByPhone(@PathVariable long phone) {
		
		return customerService.findCustomerByPhone(phone);
	}

}
