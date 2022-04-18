package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;

public interface ItemService {

	Items addItems(Long restaurantId, Items items) throws ResourceNotFoundException;

Items addItems(Items items);

Items updateItems(Items items) throws ResourceNotFoundException;

	Items updateById(Items items, Long itemId) throws ResourceNotFoundException;

	Items deleteById(Long itemId) throws ResourceNotFoundException;

	List<Items> getAllItems();

	Items findById(Long itemId) throws ResourceNotFoundException;

	Items AddItemsByRestName(String restaurantName, Items items);

	List<Items> getItemsByRestaurantName(String restaurantName);

	Items deleteByName(String itemName);



	
}
