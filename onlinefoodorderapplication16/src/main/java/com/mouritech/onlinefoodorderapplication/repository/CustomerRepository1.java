package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mouritech.onlinefoodorderapplication.entity.Customer;


public interface CustomerRepository1 extends JpaRepository<Customer, Long>  {
	List<Customer> findAll();

    Customer findByCustomerEmail(String customerEmail);

    Customer findUserByCustomerEmail(String customerEmail);
    //String findByCustomerEmail(String customerEmail);

}
