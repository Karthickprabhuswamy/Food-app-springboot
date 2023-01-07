package com.ty.foodappservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.ProaductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProaductService proaductService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		
		return proaductService.saveProduct(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		
		return proaductService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id) {
		
		return proaductService.getProaductById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int id) {
		
		return proaductService.deleteProductById(id);
		
	}

}
