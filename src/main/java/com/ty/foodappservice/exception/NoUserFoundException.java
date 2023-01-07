package com.ty.foodappservice.exception;

public class NoUserFoundException  extends RuntimeException{
	
	private String massage = "No USer Found";

	public NoUserFoundException(String massage) {
		this.massage = massage;
	}
	
	public NoUserFoundException() {
		
		
	}

	public String getMassage() {
		return massage;
	}
	

}
