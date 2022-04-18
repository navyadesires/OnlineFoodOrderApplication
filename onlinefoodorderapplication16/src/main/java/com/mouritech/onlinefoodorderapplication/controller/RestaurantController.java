package com.mouritech.onlinefoodorderapplication.controller;

//import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.dto.ItemDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantvarificationDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurentDto;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.service.ItemService;
import com.mouritech.onlinefoodorderapplication.service.RestaurantService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/restaurant")
@Api(value = "")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private ItemService itemService;

	@PostMapping("/addrestaurantinfo")
	public ResponseEntity<?> addRestaurantInformation(@RequestBody Restaurant restaurant) {
		restaurantService.addRestaurantInformation(restaurant);

		return ResponseEntity.ok().body("all restaurant information inserted");

	}

//	@GetMapping("/getrestaurantbyemaiandpassword/{restaurantEmail}/{restaurantPassword}")
//	public ResponseEntity<?> findRestaurantByEmailAndPassword(@PathVariable(value = "restaurantEmail") String restaurantEmail,
//			@PathVariable(value ="restaurantPassword") String restaurantPassword){
//		
//		Restaurant result = restaurantService.findRestaurantByEmailAndPassword(restaurantEmail,restaurantPassword);
//		if(result!=null) {
//			return ResponseEntity.ok().body(result.getRestaurantName());
//		}
//	
//		else {
//			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not found please sign in first");
//			
//		}
//		
//	}

	@GetMapping("/getrestaurantbyemaiandpassword/{restaurantEmail}/{restaurantPassword}")
	public ResponseEntity<?> findRestaurantByEmailAndPassword(
			@PathVariable(value = "restaurantEmail") String restaurantEmail,
			@PathVariable(value = "restaurantPassword") String restaurantPassword) {

		Restaurant result = restaurantService.findRestaurantByEmailAndPassword(restaurantEmail, restaurantPassword);

		// Non changed one

		if (result != null) {
			return ResponseEntity.ok()
					.body("login successful and " + "Restaurant name is ==" + result.getRestaurantName());

			// return ResponseEntity.ok().body({ mesage:"login successful",
			// username: result.getRestaurantName();
			// });

		}

		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not found please sign in first");

		}

	}

	@PostMapping("/getrestaurantbyemailandpassword")
	public ResponseEntity<?> findRestaurantByEmailAndPassword(
			@RequestBody RestaurantvarificationDto restaurantvarificationDto) {

		// Restaurant result =
		// restaurantService.findRestaurantByEmailAndPassword(restaurantvarificationDto.getRestaurantEmail(),restaurantvarificationDto.getRestaurantPassword());

		// Changed Part

		Restaurant emailCheck = restaurantService.findRestaurantByEmail(restaurantvarificationDto.getRestaurantEmail());

		if (emailCheck != null) {
			Restaurant result = restaurantService.findRestaurantByEmailAndPassword(
					restaurantvarificationDto.getRestaurantEmail(), restaurantvarificationDto.getRestaurantPassword());

			if (result != null) {
				return ResponseEntity.ok()
						.body("login successful and " + "Restaurant name is ==" + result.getRestaurantName());
			}

			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password Not Found");

			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Not Found");
		}

		// don't change

//                if(result!=null) {
//        	  return ResponseEntity.ok().body("login successful and "+"Restaurant name is =="+result.getRestaurantName());
//        	
//        }
//
//        else {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not found please sign in first");
//
//        }

	}

	@PutMapping("/updaterestaurantinfobyname")
	public ResponseEntity<?> updaterestaurantinfobyname(@RequestBody Restaurant restaurant) {

		ResponseEntity<?> result = restaurantService.updaterestaurantinfobyname(restaurant);
		return result;
	}

	@PostMapping("/getrestaurantbyemailandpasswordcheck")
	public ResponseEntity<?> checkRestauramtEmailAndPassword(@RequestBody RestaurantvarificationDto restaurantDto) {
		if (restaurantDto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Enter Email and password");
		} else {

			ResponseEntity<?> ckeckLogin = restaurantService.checkRestauramtEmailAndPassword(restaurantDto);
			return ckeckLogin;

		}

	}

	@PostMapping("/insertitemsByrestaurantemaiandpassword")
	public ResponseEntity<?> insertItems(@RequestBody RestaurantItemsDto restaurantItemsDto) {

		if (restaurantItemsDto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Enter Email and password, items");
		} else {

			ResponseEntity<?> itemsInsert = restaurantService.insertItems(restaurantItemsDto);
			return itemsInsert;

		}

	}

//Adding  restaurant details using entity class
	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);

		return newRestaurant;
	}

	@GetMapping("/getAll")
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> listRest = restaurantService.getAllRestaurant();
		return listRest;
	}

	@GetMapping("/getByRestaurantId/{restaurantId}")
	public Restaurant getRestaurantById(@PathVariable(value = "restaurantId") Long restaurantId)
			throws ResourceNotFoundException {

		return restaurantService.getById(restaurantId);
	}

	@PutMapping("/updateRestaurant/{restaurantId}")
	public Restaurant updateRestaurantById(@PathVariable(value = "restaurantId") Long restaurantId,
			@RequestBody Restaurant restaurant) throws ResourceNotFoundException {

		return restaurantService.updateRestaurantById(restaurantId, restaurant);
	}

	@DeleteMapping("/delateRestaurant/{restaurantId}")
	public Restaurant deleteRestaurant(@PathVariable(value = "restaurantId") Long restaurantId)
			throws ResourceNotFoundException {
		return restaurantService.deleteRestaurant(restaurantId);
	}

	@PostMapping("/addItems/{restaurantId}")
	public Items addItems(@PathVariable(value = "restaurantId") Long restaurantId, @RequestBody Items items)
			throws ResourceNotFoundException {
		return itemService.addItems(restaurantId, items);
	}

	@GetMapping("/getRestaurantandItems/{restaurantName}")
	public ResponseEntity<Restaurant> getrestaurantInfoAndItems(
			@PathVariable(value = "restaurantName") String restaurantName) {
		return restaurantService.getrestaurantInfoAndItems(restaurantName);

	}

	@DeleteMapping("/deleteItems/{restaurantName}/{itemName}")
	public ResponseEntity<Restaurant> deleteByItemsusingRestaurantName(
			@PathVariable(value = "restaurantName") String restaurantName,
			@PathVariable(value = "itemName") String itemName) throws ResourceNotFoundException {

		return restaurantService.deleteByItemsusingRestaurantName(restaurantName, itemName);
	}

	@PutMapping("updateItems/{restaurantName}/{itemName}")
	public ResponseEntity<Restaurant> updateByItemsusingRestaurantName(
			@PathVariable(value = "restaurantName") String restaurantName,
			@PathVariable(value = "itemName") String itemName, @RequestBody Items items)
			throws ResourceNotFoundException {

		return restaurantService.updateByItemsusingRestaurantName(restaurantName, itemName, items);
	}

	@GetMapping("/getrestaurantAndItemsByCity/{restaurantCity}")
	public List<RestaurentDto> getbyCity(@PathVariable(value = "restaurantCity") String restaurantCity) {

		return restaurantService.getAllByCity(restaurantCity);
	}

	@GetMapping("/getorderdetails/{restaurantName}")
	public Orderdetails getOrderDetails(@PathVariable(value = "restaurantName") String restaurantName)
			throws ResourceNotFoundException {

		return restaurantService.getOrderDetails(restaurantName);

	}

}
