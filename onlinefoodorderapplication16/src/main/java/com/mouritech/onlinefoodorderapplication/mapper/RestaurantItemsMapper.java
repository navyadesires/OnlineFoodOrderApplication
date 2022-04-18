package com.mouritech.onlinefoodorderapplication.mapper;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Component
public class RestaurantItemsMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public RestaurantItemsDto convertEntityToDto(Restaurant restaurant)
	{
		return modelMapper.map(restaurant, RestaurantItemsDto.class);
	}
	
	public Restaurant convertDtoToEntity(RestaurantItemsDto restaurantItemsDto)
	{
		return modelMapper.map(restaurantItemsDto,Restaurant.class);
	}


}
