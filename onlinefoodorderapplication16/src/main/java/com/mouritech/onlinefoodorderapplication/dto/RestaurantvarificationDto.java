package com.mouritech.onlinefoodorderapplication.dto;


public class RestaurantvarificationDto {
	
	private String restaurantPassword;

	private String restaurantEmail;

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

	public RestaurantvarificationDto(String restaurantPassword, String restaurantEmail) {
		super();
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	}

	public RestaurantvarificationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
