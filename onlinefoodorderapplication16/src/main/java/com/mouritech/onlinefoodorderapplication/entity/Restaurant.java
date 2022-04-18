package com.mouritech.onlinefoodorderapplication.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private long restaurantId;
	
	@Column(name = "restaurant_name")
	@NotNull
	@NotBlank
	@NotEmpty
	private String restaurantName;
	
	@Column(name = "restaurant_password")
	@NotNull
	@NotBlank
	@NotEmpty
	private String restaurantPassword;
	
	@Column(name = "restaurant_email")
	@NotNull
	@NotBlank
	@NotEmpty
	private String restaurantEmail;
	
	@Column(name = "restaurant_address")
	private String restaurantAddress;
	
	@Column(name = "restaurant_city")
	private String restaurantCity;
	
	@Column(name = "restaurant_state")
	private String restaurantState;
	
	@Column(name = "restaurant_image_name")
	private String restaurantImageName;
	
	
	@Column(name = "restaurant_country")
	private String restaurantcountry;
	
	@Column(name = "restaurant_pincode")
	private int restaurantPincode;
	
	@Column(name = "restaurant_manager_first_name")
	private String restaurantManagerFirstName;
	
	@Column(name = "restaurant_manager_last_name")
	private String restaurantManagerLastName;
	
	@Column(name = "restaurant_manager_number")
	private String restaurantManagerNumber;
	
	@Column(name = "restaurant_manager_email_id")
	private String restaurantManagerEmail;
	
	@OneToMany(mappedBy = "restaurant", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Items> items;

//	@OneToMany(mappedBy = "restaurant",orphanRemoval = true, cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
//	private List<Orderdetails> orderdetails;
	
//	@OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
//	private List<Customer> customer;
	
	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

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

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantCity() {
		return restaurantCity;
	}

	public void setRestaurantCity(String restaurantCity) {
		this.restaurantCity = restaurantCity;
	}

	public String getRestaurantState() {
		return restaurantState;
	}

	public void setRestaurantState(String restaurantState) {
		this.restaurantState = restaurantState;
	}
	

	public String getRestaurantImageName() {
		return restaurantImageName;
	}

	public void setRestaurantImageName(String restaurantImageName) {
		this.restaurantImageName = restaurantImageName;
	}

	public String getRestaurantcountry() {
		return restaurantcountry;
	}

	public void setRestaurantcountry(String restaurantcountry) {
		this.restaurantcountry = restaurantcountry;
	}

	public int getRestaurantPincode() {
		return restaurantPincode;
	}

	public void setRestaurantPincode(int restaurantPincode) {
		this.restaurantPincode = restaurantPincode;
	}

	public String getRestaurantManagerFirstName() {
		return restaurantManagerFirstName;
	}

	public void setRestaurantManagerFirstName(String restaurantManagerFirstName) {
		this.restaurantManagerFirstName = restaurantManagerFirstName;
	}

	public String getRestaurantManagerLastName() {
		return restaurantManagerLastName;
	}

	public void setRestaurantManagerLastName(String restaurantManagerLastName) {
		this.restaurantManagerLastName = restaurantManagerLastName;
	}

	public String getRestaurantManagerNumber() {
		return restaurantManagerNumber;
	}

	public void setRestaurantManagerNumber(String restaurantManagerNumber) {
		this.restaurantManagerNumber = restaurantManagerNumber;
	}

	public String getRestaurantManagerEmail() {
		return restaurantManagerEmail;
	}

	public void setRestaurantManagerEmail(String restaurantManagerEmail) {
		this.restaurantManagerEmail = restaurantManagerEmail;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	


//	public List<Customer> getCustomers() {
//			return customer;
//	}
//
//	public void setCustomers(List<Customer> customer) {
//		this.customer = customer;
//	}
	
//	public List<Orderdetails> getOrderdetails() {
//		return orderdetails;
//	}
//
//	public void setOrderdetails(List<Orderdetails> orderdetails) {
//		this.orderdetails = orderdetails;
//	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String restaurantName, String restaurantPassword, String restaurantEmail,
			String restaurantAddress, String restaurantCity, String restaurantState, String restaurantcountry,
			int restaurantPincode, String restaurantManagerFirstName, String restaurantManagerLastName,
			String restaurantManagerNumber, String restaurantManagerEmail, List<Items> items) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.restaurantAddress = restaurantAddress;
		this.restaurantCity = restaurantCity;
		this.restaurantState = restaurantState;
		this.restaurantcountry = restaurantcountry;
		this.restaurantPincode = restaurantPincode;
		this.restaurantManagerFirstName = restaurantManagerFirstName;
		this.restaurantManagerLastName = restaurantManagerLastName;
		this.restaurantManagerNumber = restaurantManagerNumber;
		this.restaurantManagerEmail = restaurantManagerEmail;
		this.items = items;
	}

	public Restaurant(long restaurantId, String restaurantName, String restaurantPassword, String restaurantEmail,
			String restaurantAddress, String restaurantCity, String restaurantState, String restaurantcountry,
			int restaurantPincode, String restaurantManagerFirstName, String restaurantManagerLastName,
			String restaurantManagerNumber, String restaurantManagerEmail, List<Items> items) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.restaurantAddress = restaurantAddress;
		this.restaurantCity = restaurantCity;
		this.restaurantState = restaurantState;
		this.restaurantcountry = restaurantcountry;
		this.restaurantPincode = restaurantPincode;
		this.restaurantManagerFirstName = restaurantManagerFirstName;
		this.restaurantManagerLastName = restaurantManagerLastName;
		this.restaurantManagerNumber = restaurantManagerNumber;
		this.restaurantManagerEmail = restaurantManagerEmail;
		this.items = items;
	}

	public Restaurant(String restaurantName, String restaurantPassword, String restaurantEmail,
			String restaurantAddress, String restaurantCity, String restaurantState, String restaurantcountry,
			int restaurantPincode, String restaurantManagerFirstName, String restaurantManagerLastName,
			String restaurantManagerNumber, String restaurantManagerEmail) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.restaurantAddress = restaurantAddress;
		this.restaurantCity = restaurantCity;
		this.restaurantState = restaurantState;
		this.restaurantcountry = restaurantcountry;
		this.restaurantPincode = restaurantPincode;
		this.restaurantManagerFirstName = restaurantManagerFirstName;
		this.restaurantManagerLastName = restaurantManagerLastName;
		this.restaurantManagerNumber = restaurantManagerNumber;
		this.restaurantManagerEmail = restaurantManagerEmail;
	}

	public Restaurant(long restaurantId, String restaurantName, String restaurantPassword, String restaurantEmail,
			String restaurantAddress, String restaurantCity, String restaurantState, String restaurantcountry,
			int restaurantPincode, String restaurantManagerFirstName, String restaurantManagerLastName,
			String restaurantManagerNumber, String restaurantManagerEmail) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.restaurantAddress = restaurantAddress;
		this.restaurantCity = restaurantCity;
		this.restaurantState = restaurantState;
		this.restaurantcountry = restaurantcountry;
		this.restaurantPincode = restaurantPincode;
		this.restaurantManagerFirstName = restaurantManagerFirstName;
		this.restaurantManagerLastName = restaurantManagerLastName;
		this.restaurantManagerNumber = restaurantManagerNumber;
		this.restaurantManagerEmail = restaurantManagerEmail;
	}

//	public Restaurant(long restaurantId, String restaurantName, String restaurantPassword, String restaurantEmail,
//			String restaurantAddress, String restaurantCity, String restaurantState, String restaurantcountry,
//			int restaurantPincode, String restaurantManagerFirstName, String restaurantManagerLastName,
//			String restaurantManagerNumber, String restaurantManagerEmail, List<Items> items, List<Orderdetails> orderdetails) {
//		super();
//		this.restaurantId = restaurantId;
//		this.restaurantName = restaurantName;
//		this.restaurantPassword = restaurantPassword;
//		this.restaurantEmail = restaurantEmail;
//		this.restaurantAddress = restaurantAddress;
//		this.restaurantCity = restaurantCity;
//		this.restaurantState = restaurantState;
//		this.restaurantcountry = restaurantcountry;
//		this.restaurantPincode = restaurantPincode;
//		this.restaurantManagerFirstName = restaurantManagerFirstName;
//		this.restaurantManagerLastName = restaurantManagerLastName;
//		this.restaurantManagerNumber = restaurantManagerNumber;
//		this.restaurantManagerEmail = restaurantManagerEmail;
//		this.items = items;
//		this.orderdetails = orderdetails;
//	}

	


}
