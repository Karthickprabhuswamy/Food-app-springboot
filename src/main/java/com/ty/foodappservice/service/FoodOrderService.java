package com.ty.foodappservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.FoodOrderDao;
import com.ty.foodappservice.dto.Customer;
import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.dto.Items;
import com.ty.foodappservice.dto.ResponseStructure;

@Service
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> placeFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();

		double totalcost = 0;
		
		List<Items> list = 	foodOrder.getItems();
		for (Items items : list) {
			
			totalcost = items.getCost()*items.getQuantity()+totalcost;
			items.setFoodOrder(foodOrder);
		}
		
		foodOrder.setCost(totalcost);
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessege("Sucess");
		responseStructure.setDate(foodOrderDao.placeFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
	}

}
