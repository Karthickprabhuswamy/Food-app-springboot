package com.ty.foodappservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
@Data
@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime localDateTime;
	
	private double cost;
	
	@OneToMany(mappedBy = "foodOrder",cascade = CascadeType.ALL)
	private List<Items> items;

	
}
