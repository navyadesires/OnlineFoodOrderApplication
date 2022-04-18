package com.mouritech.onlinefoodorderapplication.exceptions;


	public class OrderNotFoundException extends IllegalArgumentException {
	    public OrderNotFoundException(String msg) {
	        super(msg);
	    }

}
