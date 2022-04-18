package com.mouritech.onlinefoodorderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

	Customer findByCustomerName(String customerName);
	
	Customer findByCustomerEmail(String customerEmail);

	Customer findByCustomerPassword(String customerPassword);
}
