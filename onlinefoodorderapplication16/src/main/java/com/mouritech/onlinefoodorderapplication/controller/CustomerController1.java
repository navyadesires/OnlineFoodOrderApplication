package com.mouritech.onlinefoodorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;

import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;
import com.mouritech.onlinefoodorderapplication.service.CustomerService1;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
@Api(value = "")
public class CustomerController1 {
	  @Autowired
	    CustomerRepository1 userRepository;

	    @Autowired
	    AuthenticationService authenticationService;

	    @Autowired
	   CustomerService1 customerService;

	    @GetMapping("/all")
	    public List<Customer> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
	        authenticationService.authenticate(token);
	        return userRepository.findAll();
	    }

	    @PostMapping("/signup")
	    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
	     return customerService.signUp(signupDto);
	    
	    }
	    @PostMapping("/signIn")
	    public ResponseEntity<Object> Signup(@RequestBody SignInDto signInDto) throws CustomException {
	    SignInResponseDto signInResponseDto = customerService.signIn(signInDto);

	    if (signInResponseDto != null) {
	    SignInResponseDto result = customerService.signIn(signInDto);



	    if (result != null) {
	    return new ResponseEntity<Object>(result, HttpStatus.OK);
	       
	    }



	    else {
	    return ResponseEntity.ok().body("Password is Wrong");



	    }
	    } else {
	    return ResponseEntity.ok().body("Email is Not Found");
	    }


	    }
	   
//	    @PostMapping("/signIn")
//	    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
//	        return customerService.signIn(signInDto);
//	        //return ResponseEntity.ok().body("login successful and"+"Customer id is =="+result.getCustomerName());
//	    }
//	

}
