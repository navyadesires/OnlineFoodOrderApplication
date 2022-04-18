package com.mouritech.onlinefoodorderapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;


public class RestaurentDto {
	private String restaurantName;
	@JsonIgnore
	private String restaurantCity;
	public RestaurentDto(Restaurant restaurant) {
		

		this.setRestaurantName(restaurant.getRestaurantName());
        this.setRestaurantCity(restaurant.getRestaurantCity());
		
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantCity() {
		return restaurantCity;
	}
	public void setRestaurantCity(String restaurantCity) {
		this.restaurantCity = restaurantCity;
	}
	public RestaurentDto(String restaurantName, String restaurantCity) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantCity = restaurantCity;
	}
	public RestaurentDto() {
		// TODO Auto-generated constructor stub
	}
	

}
