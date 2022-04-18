package com.mouritech.onlinefoodorderapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	AuthenticationToken findTokenByCustomer(Customer customer);
    AuthenticationToken findTokenByToken(String token);

}
