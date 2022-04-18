package com.mouritech.onlinefoodorderapplication.dto;

import java.util.List;

import com.mouritech.onlinefoodorderapplication.entity.Items;

public class RestaurantItemsDto {
	
	private String restaurantPassword;

	private String restaurantEmail;
	
	private List<Items> items;

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public RestaurantItemsDto(String restaurantPassword, String restaurantEmail, List<Items> items) {
		super();
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.items = items;
	}

	public RestaurantItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

		
}
