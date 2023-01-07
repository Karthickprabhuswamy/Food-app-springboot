package com.ty.foodappservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository foodOrderRepository;
	
	public FoodOrder placeFoodOrder(FoodOrder foodOrder) 
	{
		return foodOrderRepository.save(foodOrder);
		
	}
	
	
	
}
