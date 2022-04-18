package com.mouritech.onlinefoodorderapplication.entity;



//import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_Id")
		private long itemId;
		
		private String itemName;
		private String itemImageName;
		
		private int itemPrice;
		
		private String itemDescription;
		
		//private int itemQuantity;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "restaurant_id")
		 @JsonIgnore
		private Restaurant restaurant;
		

		public long getItemId() {
			return itemId;
		}

		public void setItemId(long itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getItemImageName() {
			return itemImageName;
		}

		public void setItemImageName(String itemImageName) {
			this.itemImageName = itemImageName;
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

//		public int getItemQuantity() {
//			return itemQuantity;
//		}
//
//		public void setItemQuantity(int itemQuantity) {
//			this.itemQuantity = itemQuantity;
//		}

		public Restaurant getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
		
		

			}

