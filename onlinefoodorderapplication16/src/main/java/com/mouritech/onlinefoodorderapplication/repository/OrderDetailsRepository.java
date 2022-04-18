package com.mouritech.onlinefoodorderapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<Orderdetails, Long>{

	Orderdetails findByFoodCart_CartId(long cartId);
}
