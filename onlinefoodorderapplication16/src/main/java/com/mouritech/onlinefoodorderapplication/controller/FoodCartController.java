package com.mouritech.onlinefoodorderapplication.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.common.APIResponse;
import com.mouritech.onlinefoodorderapplication.dto.AddToCartDto;
import com.mouritech.onlinefoodorderapplication.dto.CartDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Items;
//import com.mouritech.onlinefoodorderapplication.entity.User;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CartItemNotExistException;
import com.mouritech.onlinefoodorderapplication.exceptions.ProductNotExistException;
import com.mouritech.onlinefoodorderapplication.service.AuthenticationService;
import com.mouritech.onlinefoodorderapplication.service.FoodCartService;
import com.mouritech.onlinefoodorderapplication.serviceImpl.FoodCartServiceImpl;
import com.mouritech.onlinefoodorderapplication.serviceImpl.ItemServiceImpl;

import io.swagger.annotations.Api; 



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/foodcart")
@Api(value = "")
public class FoodCartController {
	@Autowired
	private FoodCartService cartService;
	@Autowired
	private FoodCartServiceImpl cartService1;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private ItemServiceImpl itemService;
	
	@PostMapping("Cart")
	public FoodCart insertCart(@RequestBody FoodCart newCart) {
		return cartService.insertCart(newCart);
	}
	@GetMapping("Cart")
	public List<FoodCart> showAllCarts() {
		return cartService.showAllCarts();
	}
	@GetMapping("Cart/{cid}")
	public FoodCart showCartById(@PathVariable("cid") Long CartId) throws ResourceNotFoundException  {
		return cartService.showCartById(CartId);
	}
	@PutMapping("Cart/{cid}")
	public FoodCart updateCartById(@PathVariable("cid") Long CartId, @RequestBody FoodCart Cart) throws ResourceNotFoundException
			{
		return cartService.updateCartById(CartId, Cart);
	}
//	@DeleteMapping("Cart/{cid}")
//	public String deleteCartById(@PathVariable("cid") long CartId) throws ResourceNotFoundException  {
//		cartService.deleteCartById(CartId);
//		return "deleted the Cart";
//	}
	
	 @DeleteMapping("Cart/{cid}")
	    public FoodCart deleteCartById(@PathVariable("cid") long CartId) throws ResourceNotFoundException  {
	        return cartService.deleteCartById(CartId);
	    }
	
//	@PostMapping("/createcartusingcustNameanditem/{customerName}/{restaurantName}/{itemName}/{quantity}")
//	public FoodCart createCart(@PathVariable("customerName") String customerName,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName, @PathVariable("quantity") int quantity)
//	{
//		return cartService.createCart(customerName,restaurantName,itemName, quantity);
//	}
	
	@PostMapping("/createcartusingcustNameanditem/{customerName}/{restaurantName}/{itemName}")
	public FoodCart createCart(@PathVariable("customerName") String customerName,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName)
	{
		return cartService.createCart(customerName,restaurantName,itemName);
	}
	
	
	@PutMapping("/updateCartAddNewItems/{cartId}/{restaurantName}/{itemName}")
	public FoodCart addItemsInCart(@PathVariable("cartId") Long cartId,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName) throws ResourceNotFoundException {
		return cartService.addItemsInCart(cartId,restaurantName,itemName);
	}
	
//	@PutMapping("/updateCartAddNewItems/{cartId}/{restaurantName}/{itemName}/{quantity}")
//	public FoodCart addItemsInCart(@PathVariable("cartId") Long cartId,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName, @PathVariable("quantity") int quantity)) throws ResourceNotFoundException {
//		return cartService.addItemsInCart(cartId,restaurantName,itemName);
//	}
	 @PostMapping("/add")
	    public ResponseEntity<APIResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
	                                                 @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
	        authenticationService.authenticate(token);
	        Customer customer = authenticationService.getCustomer(token);
	      Items product = itemService.getProductById(addToCartDto.getItemId());
	        //System.out.println("product to add"+  product.getName());
	        cartService1.addToCart1(addToCartDto, product, customer);
	        return new ResponseEntity<APIResponse>(new APIResponse(true, "Added to cart"), HttpStatus.CREATED);

	    }
	 @GetMapping("/")
	    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
	        authenticationService.authenticate(token);
	        Customer customer = authenticationService.getCustomer(token);
	        CartDto cartDto = cartService1.listCartItems(customer);
	        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	    }
	 @DeleteMapping("/delete/{cartItemId}")
	    public ResponseEntity<APIResponse> deleteCartItem(@PathVariable("cartItemId") long itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
	        authenticationService.authenticate(token);
	        long userId = authenticationService.getCustomer(token).getCustomerId();
	        cartService1.deleteCartItem(itemID, userId);
	        return new ResponseEntity<APIResponse>(new APIResponse(true, "Item has been removed"), HttpStatus.OK);
	    }

}