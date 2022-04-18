//package com.mouritech.onlinefoodorderapplication.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mouritech.onlinefoodorderapplication.entity.Bill;
//import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
//import com.mouritech.onlinefoodorderapplication.service.BillService;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/bills")
//public class BillController { 
//
////	@Autowired
////	private BillService billService;
//	
//	//save an Bill
//		@PostMapping("/bills")
//		public Bill saveBil(@Valid @RequestBody Bill bill)
//		{
//			return billService.saveBill(bill);
//		}
//		//get all bills
//		@GetMapping("/bills")
//		public List<Bill> getAllBills()
//		{
//			return billService.getAllBills();
//		}
//		//update bills
//		@PutMapping("/bills/{billId}")
//		public ResponseEntity<Bill> updateBill(@PathVariable(value = "billId") Long billId,@RequestBody Bill bill) throws ResourceNotFoundException {
//		
//			return billService.updateBills(billId,bill);
//		
//		}
//		//delete bill
//		@DeleteMapping("/bills/{billId}")
//		public ResponseEntity<?> deleteBill( 
//				@PathVariable(value = "billId") int billId)
//		{
//			return billService.deleteBill(billId);
//			
//		}
//
//		//get bill by billId
//		@GetMapping("/bills/{id}")
//	  public ResponseEntity<Bill> getBillById(@PathVariable(value = "id") Long billId) throws ResourceNotFoundException
//	      {
//			return billService.getBillById(billId);
//			
//			
//		}
//		
//		@PostMapping("/createbillusingOrderId/{orderId}")
//		
//		public Bill createBill(@PathVariable(value = "orderId") Long orderId) throws ResourceNotFoundException {
//	
//			
//			return billService.createBill(orderId);
//	
//		
//		
//
//}
//}