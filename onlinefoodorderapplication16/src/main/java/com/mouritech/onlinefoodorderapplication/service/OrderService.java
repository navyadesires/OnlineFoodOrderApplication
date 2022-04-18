package com.mouritech.onlinefoodorderapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.dto.PlaceOrderDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.Order;
import com.mouritech.onlinefoodorderapplication.entity.OrderItem;
import com.mouritech.onlinefoodorderapplication.exceptions.OrderNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.OrderItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.OrderRepository;
import com.mouritech.onlinefoodorderapplication.serviceImpl.FoodCartServiceImpl;

@Service
@Transactional
public class OrderService {
	@Autowired
    private FoodCartServiceImpl cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;
    public void placeOrder(Customer customer, List<PlaceOrderDto> list) {
      
        CartDto cartDto = cartService.listCartItems(customer);

        //List<CartItemDto> cartItemDtoList = cartDto.getcartItems();

      
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        //newOrder.setSessionId(sessionId);
        newOrder.setCustomer(customer);
        newOrder.setTotalPrice(cartDto.getTotalCost());
        orderRepository.save(newOrder);
        List<OrderItem>  orderItemList = new ArrayList<>();
        for (PlaceOrderDto cartItemDto : list) {
           
            OrderItem orderItem = new OrderItem();
            orderItem.setCreatedDate(new Date());
            orderItem.setPrice(cartItemDto.getItemPrice());
            //orderItem.setItems(cartItemDto.getItemName());
            orderItem.setQuantity(cartItemDto.getItemQuantity());
            orderItem.setItemName(cartItemDto.getItemName());
            orderItem.setTotal(cartItemDto.getItemPrice() * cartItemDto.getItemQuantity());
            orderItem.setOrder(newOrder);
            orderItemList.add(orderItemsRepository.save(orderItem));
        }
         
        //
        cartService.deleteUserCartItems(customer);
    }

    public List<Order> listOrders(Customer customer) {
        return orderRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
//        ByCustomerOrderByCreatedDateDesc
    }


    public Order getOrder(long orderId) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get();
        }
        throw new OrderNotFoundException("Order not found");
    }

}
