package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;


@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long>{

	List<FoodCart> findByItems_ItemId(long itemId);

	FoodCart findByItems_ItemName(String itemName);

	List<FoodCart> findAllByCustomerOrderByCreatedDateDesc(Customer customer);

    List<FoodCart> deleteByCustomer(Customer customer);


}
