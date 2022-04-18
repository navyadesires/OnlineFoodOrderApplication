package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.dto.OrderDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartRepository;
import com.mouritech.onlinefoodorderapplication.repository.OrderDetailsRepository;
import com.mouritech.onlinefoodorderapplication.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsRepository orderRepository;
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	
	@Override
	public Orderdetails saveOrder(Orderdetails order) {
	
		return orderRepository.save(order);
	}

	
	@Override
	public List<Orderdetails> getAllOrders() {
		return  orderRepository.findAll();
	}


	@Override
	public ResponseEntity<Orderdetails> updateOrders(Long orderId, Orderdetails orderdetails) throws ResourceNotFoundException {
		Orderdetails existingOrderDetails = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException());
		existingOrderDetails.setOrderDate(LocalDate.now());
	
		existingOrderDetails.setCart(orderdetails.getCart());
		
		
		orderRepository.save(existingOrderDetails);
	
		
		return ResponseEntity.ok(existingOrderDetails);
	}


	@Override
	public ResponseEntity<?> deleteOrder(Long orderId) throws ResourceNotFoundException {

		Orderdetails existingOrderDetails = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException());

		 if(existingOrderDetails==null) {
			 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order ID is not present");
				 
			 }
			 else {
				
				 orderRepository.delete(existingOrderDetails);
				 
				 return ResponseEntity.status(HttpStatus.OK).body(existingOrderDetails);

			}
		
	}


	@Override
	public ResponseEntity<Orderdetails> getOrderById(long orderId) throws ResourceNotFoundException {
		
		Orderdetails existingOrderDetails = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException());
				 
				 return ResponseEntity.status(HttpStatus.OK).body(existingOrderDetails);

		

	}
	
	public long generateCustId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long cId = (long) rand.nextInt(upperbound);
		return  cId; 
	
	}


	@Override
	public Orderdetails createOrder(long cartId) throws ResourceNotFoundException {

		FoodCart foodCart = foodCartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException());
		
		Orderdetails orderdetails = new Orderdetails();
		orderdetails.setOrderId(generateCustId());
		orderdetails.setOrderDate(LocalDate.now());
		orderdetails.setCart(foodCart);
		orderRepository.save(orderdetails);
		
		return orderdetails;
	}


	@Override
	public Orderdetails createOrderData(long cartId, OrderDto orderDto) {
		Orderdetails orderdetails = new Orderdetails();
		Optional<FoodCart> foodCart = foodCartRepository.findById(cartId);
		if(foodCart.isPresent()) {
			orderdetails.setCart(foodCart.get());
			
		}
		orderdetails.setOrderDate(LocalDate.now());
		orderdetails.setItemName(orderDto.getItemName());
		orderdetails.setItemDescription(orderDto.getItemDescription());
		orderdetails.setItemQuantity(orderDto.getItemQuantity());
		orderdetails.setTotalPrice(orderDto.getTotalPrice());
		orderdetails.setPrice(orderDto.getItemPrice());
		System.out.println("orderDto  "+ orderDto.getItemPrice());
		orderRepository.save(orderdetails);
		return orderdetails;
		
	}


//	@Override
//	public Orderdetails createcustomerOrder(Long orderId, Long customerId, Long restaurantId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//	public OrderDetails createcustomerOrder(long orderId, Long CustomerId, Long restuarantId) {
//	OrderDetails orderDetails = new OrderDetails();
//	
//	orderdetails.setOrderDate(LocalDate.now());
//	orderdetails.setItemName(orderDto.getItemName());
//	orderdetails.setItemDescription(orderDto.getItemDescription());
//	orderdetails.setItemQuantity(orderDto.getItemQuantity());
//	orderdetails.setTotalPrice(orderDto.getTotalPrice());
//	
//	}

}


