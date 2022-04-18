package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.exceptions.ProductNotExistException;
import com.mouritech.onlinefoodorderapplication.repository.ItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.RestaurantRepository;
import com.mouritech.onlinefoodorderapplication.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	ItemsRepository itemsRepository;

	@Override
	public Items addItems(Long restaurantId, Items items) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException());
		items.setRestaurant(restaurant);
		Items finalItems = itemsRepository.save(items);
		return finalItems;
	}

	@Override
	public Items addItems(Items items) {
		return itemsRepository.save(items);
	}

	@Override
	public Items updateItems(Items items) throws ResourceNotFoundException {
	Items existingItems = itemsRepository.findById(items.getItemId()).orElseThrow(() -> new ResourceNotFoundException());
	existingItems.setItemName(items.getItemName());
	existingItems.setItemPrice(items.getItemPrice());
	//existingItems.setItemQuantity(items.getItemQuantity());
	existingItems.setItemDescription(items.getItemDescription());
	itemsRepository.save(existingItems);
	return existingItems;
	
	}

	@Override
	public Items updateById(Items items, Long itemId) throws ResourceNotFoundException {
		Items existingItems = itemsRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException());
		existingItems.setItemName(items.getItemName());
		existingItems.setItemPrice(items.getItemPrice());
		//existingItems.setItemQuantity(items.getItemQuantity());
		existingItems.setItemDescription(items.getItemDescription());
		itemsRepository.save(existingItems);
		return existingItems;
	}

	@Override
	public Items deleteById(Long itemId) throws ResourceNotFoundException {
		Items existingItems = itemsRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException());
		itemsRepository.delete(existingItems);
		return existingItems;
	}

	@Override
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}

	@Override
	public Items findById(Long itemId) throws ResourceNotFoundException {
		Items existingItems = itemsRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException());
		return existingItems;
	}

	@Override
	public Items AddItemsByRestName(String restaurantName, Items items) {
		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);
		items.setRestaurant(restaurant);
		Items finalItems = itemsRepository.save(items);
		return finalItems;
	}

	@Override
	public List<Items> getItemsByRestaurantName(String restaurantName) {

		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);

		List<Items> items = restaurant.getItems();
		return items;
	}

	@Override
	public Items deleteByName(String itemName) {
		
		Items items = itemsRepository.findByItemName(itemName);
		itemsRepository.delete(items);

		return items;
	}
	 public Items getProductById(long itemId) throws ProductNotExistException {
	       Optional<Items> optionalProduct = itemsRepository.findById(itemId);
	        if (!optionalProduct.isPresent())
	            throw new ProductNotExistException("Product id is invalid " + itemId);
	        return optionalProduct.get();
	    }


}
