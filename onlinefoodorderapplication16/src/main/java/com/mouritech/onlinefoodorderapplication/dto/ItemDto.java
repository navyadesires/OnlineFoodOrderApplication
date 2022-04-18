package com.mouritech.onlinefoodorderapplication.dto;


import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

public class ItemDto {

	private String itemName;
	
	private int itemPrice;
	
	private String itemDescription;
	
	//private int itemQuantity;
	
	private String restaurantName;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

//	public int getItemQuantity() {
//		return itemQuantity;
//	}
//
//	public void setItemQuantity(int itemQuantity) {
//		this.itemQuantity = itemQuantity;
//	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public ItemDto(String itemName, int itemPrice, String itemDescription, String restaurantName) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		//this.itemQuantity = itemQuantity;
		this.restaurantName = restaurantName;
	}

	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
