package com.ty.foodappservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.ProductDao;
import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.dto.ResponseStructure;

@Service
public class ProaductService {
	
	@Autowired
	ProductDao dao;
	
	public 	ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Okay");
		responseStructure.setDate(product);
		

		return  new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);

	}

	public List<Product> getAllProducts() {

		return dao.getAllProducts();

	}

	public ResponseEntity<ResponseStructure<Product>> getProaductById(int id) {

		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();

		Product product = dao.getProaductById(id);
		
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Sucess");
			responseStructure.setDate(product);
			return  new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
			
		}else {
			
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessege("Not Found");
			responseStructure.setDate(product);
			return  new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.NOT_FOUND);

		}
		
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int id) {

		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();

		
		
		if (dao.deleteProductById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessege("Sucess");
			return  new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
			
			
			
		}else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessege("Not Found");
			return  new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.NOT_FOUND);
			
		}

		}

	}
	
	 
	



