package com.mouritech.onlinefoodorderapplication.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantvarificationDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Component
 public class RestaurantMapper 
{
	
	@Autowired
	ModelMapper modelMapper;
	
	public RestaurantvarificationDto convertEntityToDto(Restaurant restaurant)
	{
		return modelMapper.map(restaurant, RestaurantvarificationDto.class);
	}
	
	public Restaurant convertDtoToEntity(RestaurantvarificationDto restaurantDto)
	{
		return modelMapper.map(restaurantDto,Restaurant.class);
	}

}