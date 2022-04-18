package com.mouritech.onlinefoodorderapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{

	void deleteByItemName(String itemName);


	Items findByItemName(String itemName);



}
