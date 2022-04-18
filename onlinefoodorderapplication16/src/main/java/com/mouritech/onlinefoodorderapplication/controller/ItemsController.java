package com.mouritech.onlinefoodorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.service.ItemService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
@Api(value = "")
public class ItemsController {
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/add")
	public Items addItems(@RequestBody Items items) {
		Items itemsAdded = itemService.addItems(items);
		return itemsAdded;
	}

	@PostMapping("/addByRestaurantId/{restaurantId}")
	public Items addItems(@PathVariable(value = "restaurantId") Long restaurantId,@RequestBody Items items) throws ResourceNotFoundException {
		return itemService.addItems(restaurantId,items);
	}
	
	@PutMapping("/update")
	public Items updateItems(@RequestBody Items items) throws ResourceNotFoundException {
		return itemService.updateItems(items);
	}
	
	@PutMapping("/updateById/{itemId}")
	public Items updateById(@PathVariable(value = "itemId") Long itemId,@RequestBody Items items) throws ResourceNotFoundException {
		return itemService.updateById(items,itemId);
	}
	
	@DeleteMapping("/deleteById/{itemId}")
	public Items deleteById(@PathVariable(value = "itemId") Long itemId) throws ResourceNotFoundException {
		return itemService.deleteById(itemId);
	}
	
	@GetMapping("/getAll")
	public List<Items> getAll(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/getByItemId/{itemId}")
	public Items getById(@PathVariable(value = "itemId") Long itemId) throws ResourceNotFoundException{
		return itemService.findById(itemId);
	}
	
	@PostMapping("addItems/{restaurantName}")
	public Items AddItemsByRestName(@PathVariable(value = "restaurantName") String restaurantName,@RequestBody Items items) {
		return itemService.AddItemsByRestName(restaurantName,items);
	}
	
	@GetMapping("/getItems/{restaurantName}")
	public List<Items> getItemsByRestaurantName(@PathVariable(value = "restaurantName") String restaurantName){
		
		return itemService.getItemsByRestaurantName(restaurantName);
	}
	@DeleteMapping("/deleteByName/{itemName}")
	public Items deleteByName(@PathVariable(value = "itemName") String itemName) {
		return itemService.deleteByName(itemName);
	}
	
	
}
