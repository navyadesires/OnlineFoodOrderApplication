package com.mouritech.onlinefoodorderapplication.exceptions;

public class CartItemNotExistException extends IllegalArgumentException {
	public CartItemNotExistException(String msg) {
        super(msg);
    }

}
