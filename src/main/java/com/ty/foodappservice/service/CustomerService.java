package com.ty.foodappservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.CustomerDao;
import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.exception.NoIdFoundException;
import com.ty.foodappservice.exception.NoUserFoundException;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {

		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Okay");
		responseStructure.setDate(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Customer>> findCustomerByEmail(String email) {

		Optional<Customer> customer = customerDao.findCustomerByEmail(email);

		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();

		if (customer != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Sucess");
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);

		} else {
			throw new NoUserFoundException("No email Found");
		}
	}

	public  ResponseEntity<ResponseStructure<Customer>> findCustomerByPhone(long phone) {

		Optional<Customer> customer = customerDao.findCustomerByPhone(phone);

		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();

		if (customer != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Sucess");
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.OK);

		} else {
			throw new NoUserFoundException("No Phone number found");
		}

	}

}
