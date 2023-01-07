package com.ty.foodappservice.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.foodappservice.dto.ResponseStructure;
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>>handler(NoIdFoundException exception){
		
		ResponseStructure<String> responseStructure =  new  ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessege("Not Found");
		responseStructure.setDate(exception.getMassage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ResponseStructure<String>>handle(NoUserFoundException exception){
		
		ResponseStructure<String> responseStructure =  new  ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessege("Not Found");
		responseStructure.setDate(exception.getMassage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);	
	}

}
