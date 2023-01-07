package com.ty.foodappservice.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	public Optional<Customer> findCustomerByEmail(String email) {

		return customerRepository.findByEmail(email);
	}

	public Optional<Customer> findCustomerByPhone(long phone) {

		return customerRepository.findByPhone(phone);
	}

}
