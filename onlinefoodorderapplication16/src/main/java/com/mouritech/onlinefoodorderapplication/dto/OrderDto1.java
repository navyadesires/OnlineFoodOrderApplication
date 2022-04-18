package com.mouritech.onlinefoodorderapplication.dto;

import javax.validation.constraints.NotNull;

import com.mouritech.onlinefoodorderapplication.entity.Order;

public class OrderDto1 {
	 private long id;
	    private @NotNull long customerId;
	    
	    public OrderDto1(Order order) {
	        this.setId(order.getId());
	        //this.setUserId(order.getUserId());
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}

		public OrderDto1() {
			// TODO Auto-generated constructor stub
		}


}
