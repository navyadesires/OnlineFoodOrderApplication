package com.mouritech.onlinefoodorderapplication.dto;

public class CustomerOrder {

	 private String itemName;
		
		private int totalPrice;
		
		private String itemDescription;
		
		private int itemQuantity;
		
		private int itemPrice;
		
		private String customerName;
		
		private String restaurantName;

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

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		
		public CustomerOrder(String itemName, int totalPrice, int itemPrice, String itemDescription, int itemQuantity,String customerName, String restaurantName) {
			super();
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemDescription = itemDescription;
			this.itemQuantity = itemQuantity;
			this.customerName = customerName;
			this.restaurantName = restaurantName;
		}
		
}
