package com.mouritech.onlinefoodorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.common.APIResponse;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;
import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;
import com.mouritech.onlinefoodorderapplication.service.OrderService;

import io.swagger.annotations.Api;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
@Api(value = "")
public class OrderController {
	  @Autowired
	    private OrderService orderService;

	    @Autowired
	    private AuthenticationService authenticationService;
	    
	    @PostMapping("/add")
	    public ResponseEntity<APIResponse> placeOrder(@RequestBody List<PlaceOrderDto> list,@RequestParam("token") String token)
	            throws AuthenticationFailException {
	     
	        authenticationService.authenticate(token);
	      
	        Customer customer = authenticationService.getCustomer(token);
	      
	        orderService.placeOrder(customer,list);
	        return new ResponseEntity<>(new APIResponse(true, "Order has been placed"), HttpStatus.CREATED);
	    }

	 
	    @GetMapping("/")
	    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws AuthenticationFailException {
	       
	        authenticationService.authenticate(token);
	       
	        Customer customer = authenticationService.getCustomer(token);
	       
	        List<Order> orderDtoList = orderService.listOrders(customer);
	       System.out.println(orderDtoList);

	        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
	    }


	   
	    @GetMapping("/{id}")
	    public ResponseEntity<Object> getOrderById(@PathVariable("id") long id, @RequestParam("token") String token)
	            throws AuthenticationFailException {
	     
	        authenticationService.authenticate(token);
	        try {
	            Order order = orderService.getOrder(id);
	            return new ResponseEntity<>(order,HttpStatus.OK);
	        }
	        catch (OrderNotFoundException e) {
	            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        }

	    }


	

}
