package com.ty.foodappservice.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int status;
	private String messege;
	private T date;

	
}
