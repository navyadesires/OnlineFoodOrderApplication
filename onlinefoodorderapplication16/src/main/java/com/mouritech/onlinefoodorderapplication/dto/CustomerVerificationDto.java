package com.mouritech.onlinefoodorderapplication.dto;

public class CustomerVerificationDto {

	private String customerEmail;
	
	private String customerPassword;

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
}
