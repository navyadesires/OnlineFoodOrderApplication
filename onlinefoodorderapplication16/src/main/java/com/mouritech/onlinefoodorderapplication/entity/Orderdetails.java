package com.mouritech.onlinefoodorderapplication.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderdetails")
public class Orderdetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;
	
	
	@Column(name = "order_date")
	private LocalDate orderDate;

	private String itemName;
	
	private double totalPrice;
	
	private String itemDescription;
	
	private int itemQuantity;
	
	private int price;
	
	//fetch = FetchType.EAGER,
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cart_id")
	//private FoodCart cart;
	private FoodCart foodCart;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "customer_id")
//	 @JsonIgnore
//	private Customer customer;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "restaurant_id")
//	 @JsonIgnore
//	private Restaurant restaurant;
//	
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Restaurant> restaurants;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
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
	
		public FoodCart getCart() {
		return foodCart;
	}

	public void setCart(FoodCart foodcart) {
		this.foodCart = foodcart;
	}
	
//	public List<Restaurant> getRestaurants() {
//		return restaurants;
//	}
//
//	public void setRestaurants(List<Restaurant> restaurants) {
//		this.restaurants = restaurants;
//	}
	

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}


}
