package com.mouritech.onlinefoodorderapplication.dto;

public class OrderDto {
	
   private String itemName;
	
	private int totalPrice;
	
	private String itemDescription;
	
	private int itemQuantity;
	
	private int itemPrice;
	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
			public int getItemPrice() {
		return itemPrice;
		}

		public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
		}

}
