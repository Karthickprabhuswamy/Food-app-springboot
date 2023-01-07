package com.ty.foodappservice.exception;

public class NoIdFoundException  extends RuntimeException{
	
	private String massage = "Given Id Not Found";
	

	public NoIdFoundException() {
		
		
	}

	public NoIdFoundException(String massage) {
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}
	
	

}
