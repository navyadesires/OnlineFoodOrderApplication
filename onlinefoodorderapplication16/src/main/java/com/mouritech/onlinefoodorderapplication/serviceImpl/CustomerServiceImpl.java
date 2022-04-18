package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;
import com.mouritech.onlinefoodorderapplication.service.CustomerService;
import com.mouritech.onlinefoodorderapplication.service.CustomerService1;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomerInformation(Customer customer) {
		
		customerRepository.save(customer);
		
	}

//	@Override
//	public boolean findCustomerByEmailPassword(String customerEmail, String customerPassword) {
//		boolean flag =false;
//		
//		Customer customer = customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
//		if(customer==null) {
//			return flag;
//		}
//		else {
//			return flag=true;
//		}
//
//	}
//	
	@Override
    public Customer findCustomerByEmailAndPassword(String customerEmail, String customerPassword) {

		Customer  customer = customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
        if(customer==null) {
            return null;
        }
        else {
            return customer;
        }
 
    }

	@Override
	public ResponseEntity<?> updatecustomerinfobyname(Customer customer) {
		
		Customer cust = customerRepository.findByCustomerName(customer.getCustomerName());
		if(cust==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not you can't update");
		}
		else {
			cust.setCustomerName(customer.getCustomerName());
			
			cust.setCustomerPassword(customer.getCustomerPassword());
			cust.setCustomerCity(customer.getCustomerCity());
			cust.setCustomerState(customer.getCustomerState());
			cust.setCustomerCountry(customer.getCustomerCountry());
			cust.setCustomerPincode(customer.getCustomerPincode());
			cust.setCustomerMobileNumber(customer.getCustomerMobileNumber());
			cust.setCustomerEmail(customer.getCustomerEmail());
			
			final Customer customerfinal = customerRepository.save(cust);
			
			 return ResponseEntity.ok(customerfinal);
		}
}

	@Override
	public Customer deleteCustomer(Long customerId) throws ResourceNotFoundException {
		
		Customer oldcustomer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException());
		customerRepository.delete(oldcustomer);
		return oldcustomer;
	}


	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}

//	@Override
//	public Customer addCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}


}