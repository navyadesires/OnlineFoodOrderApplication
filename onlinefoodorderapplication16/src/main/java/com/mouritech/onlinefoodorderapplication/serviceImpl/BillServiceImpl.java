//package com.mouritech.onlinefoodorderapplication.serviceImpl;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Random;
//
////import javax.persistence.Column;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.mouritech.onlinefoodorderapplication.entity.Bill;
//import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
//import com.mouritech.onlinefoodorderapplication.entity.Items;
//import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;
//import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
//import com.mouritech.onlinefoodorderapplication.repository.BillRepository;
//import com.mouritech.onlinefoodorderapplication.repository.OrderDetailsRepository;
//import com.mouritech.onlinefoodorderapplication.service.BillService;
//@Service
//public class BillServiceImpl implements BillService {
//	
//	@Autowired
//	private BillRepository billRepository;
//	
//	@Autowired
//	private OrderDetailsRepository detailsRepository;
//
//	@Override
//	public Bill saveBill(Bill bill) {
//		return billRepository.save(bill);
//	}
//
//	@Override
//	public List<Bill> getAllBills() {
//		return billRepository.findAll();
//	}
//
//
//
//	@Override
//	public ResponseEntity<?> deleteBill(int billId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<Bill> getBillById(Long billId) throws ResourceNotFoundException {
//
//		Bill existingbill = billRepository.findById(billId).orElseThrow(() -> new ResourceNotFoundException());
//
//		 return ResponseEntity.ok(existingbill);
//	}
//	
//	@Override
//	public ResponseEntity<Bill> updateBills(Long billId, Bill bill) throws ResourceNotFoundException {
//
//		Bill existingbill = billRepository.findById(billId).orElseThrow(() -> new ResourceNotFoundException());
//			 existingbill.setBillDate(bill.getBillDate());
//				existingbill.setTotalCost(bill.getTotalCost());
//				existingbill.setTotalItem(bill.getTotalItem());
//				existingbill.setTotalItem(bill.getTotalItem());
//				existingbill.setTotalItem(bill.getTotalItem());
//				
//				billRepository.save(existingbill);
//				 return ResponseEntity.ok(existingbill);
//
//			
//		}
//	
//	public long generateCustId() {
//		Random rand = new Random(); //instance of random class
//	      int upperbound = 255;
//	        //generate random values from 0-254
//	      Long cId = (long) rand.nextInt(upperbound);
//		return  cId; 
//	
//	}
//
//	@Override
//	public Bill createBill(Long orderId) throws ResourceNotFoundException {
//		
//		System.out.println("orderId is ==="+orderId);
//		
//		Orderdetails existingOrderDetails = detailsRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException());
//		FoodCart foodCart = existingOrderDetails.getCart();
//		Bill bill = new Bill();
//		int totalItem = bill.getTotalItem();
//		
//		int totalCost = bill.getTotalCost();
//		List<Items> items = foodCart.getItems();
//		
//		for (Items itemsresult : items) {
//			
//			totalItem= totalItem+itemsresult.getItemQuantity();
//			
//			totalCost = totalCost+(itemsresult.getItemQuantity()*itemsresult.getItemPrice());
//		}
//		
//		bill.setBillId(generateCustId());
//		bill.setBillDate(LocalDate.now());
//		bill.setTotalItem(totalItem);
//		bill.setTotalCost(totalCost);
//		bill.setOrderdetails(existingOrderDetails);
//		
//		billRepository.save(bill);
//	
//		
//		
//		return bill;
//	}
//		
//	}
//
//
