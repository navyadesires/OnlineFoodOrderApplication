package com.mouritech.onlinefoodorderapplication.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
	public AuthenticationFailException(String msg) {
        super(msg);
    }
	

}
