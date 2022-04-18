package com.mouritech.onlinefoodorderapplication.dto;

import com.mouritech.onlinefoodorderapplication.entity.Customer;

public class SignInResponseDto {
	  private String status;
	    private String token;
	    private String customerName;
	    
	    

	   
		public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

		
		
		public SignInResponseDto() {
			// TODO Auto-generated constructor stub
		}

		public SignInResponseDto(String status, String token, String customerName) {
			super();
			this.status = status;
			this.token = token;
			this.customerName = customerName;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		

		
	   

}
