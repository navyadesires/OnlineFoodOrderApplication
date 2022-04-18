package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.entity.Bill;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;

public interface BillService {
	
	Bill saveBill(Bill bill);

	List<Bill> getAllBills();


	ResponseEntity<?> deleteBill(int billId)  ;

	ResponseEntity<Bill> getBillById(Long billId) throws ResourceNotFoundException ;

	ResponseEntity<Bill> updateBills(Long billId, Bill bill) throws ResourceNotFoundException;

	Bill createBill(Long orderId) throws ResourceNotFoundException;


}
