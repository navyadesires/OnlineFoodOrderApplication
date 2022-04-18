package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.dto.RestaurentDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Restaurant findByRestaurantName(String restaurantName);

	Restaurant findByRestaurantEmailAndRestaurantPassword(String restaurantEmail, String restaurantPassword);

	Restaurant findByRestaurantEmail(String restaurantEmail);

	Restaurant findByRestaurantPassword(String restaurantPassword);

	void deleteByItems_ItemName(String itemName);
	@Query("SELECT r FROM Restaurant r WHERE r.restaurantCity LIKE %?1%")
	List<RestaurentDto> findByRestaurantCity(String restaurantCity);

}
