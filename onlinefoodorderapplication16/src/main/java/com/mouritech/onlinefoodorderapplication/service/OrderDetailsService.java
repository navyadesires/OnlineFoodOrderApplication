package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.dto.OrderDto;
import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;

public interface OrderDetailsService {
	
    
    Orderdetails saveOrder(Orderdetails order);
	List<Orderdetails> getAllOrders();
	ResponseEntity<Orderdetails> updateOrders(Long orderId, Orderdetails orderdetails) throws ResourceNotFoundException;
	ResponseEntity<?> deleteOrder(Long orderId) throws ResourceNotFoundException;
	ResponseEntity<Orderdetails> getOrderById(long orderId) throws ResourceNotFoundException;
	Orderdetails createOrder(long cartId) throws ResourceNotFoundException;
	Orderdetails createOrderData(long cartId, OrderDto orderDto);
	//Orderdetails createcustomerOrder(Long orderId, Long customerId, Long restaurantId);

}
