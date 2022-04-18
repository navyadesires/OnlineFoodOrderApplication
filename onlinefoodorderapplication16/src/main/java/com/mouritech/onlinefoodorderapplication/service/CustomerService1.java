package com.mouritech.onlinefoodorderapplication.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.config.MessageStrings;
import com.mouritech.onlinefoodorderapplication.dto.ResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInDto;
import com.mouritech.onlinefoodorderapplication.dto.SignInResponseDto;
import com.mouritech.onlinefoodorderapplication.dto.SignupDto;

import com.mouritech.onlinefoodorderapplication.entity.AuthenticationToken;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.enums.ResponseStatus;
import com.mouritech.onlinefoodorderapplication.exceptions.AuthenticationFailException;
import com.mouritech.onlinefoodorderapplication.exceptions.CustomException;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository1;
import com.mouritech.onlinefoodorderapplication.utils.Helper;


@Service
public class CustomerService1 {
	

	private static final String USER_CREATED = "Customer Registered  successfully";

	@Autowired
	CustomerRepository1 customerRepository;

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    CustomerService1 customerService;

    Logger logger = LoggerFactory.getLogger(CustomerService1.class);


    public ResponseDto signUp(SignupDto signupDto)  throws CustomException {
       
        if (Helper.notNull(customerRepository.findByCustomerEmail(signupDto.getCustomerEmail()))) {
          
            throw new CustomException("User already exists");
        }
      
        String encryptedPassword = signupDto.getCustomerPassword();
        try {
            encryptedPassword = hashPassword(signupDto.getCustomerPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }


        Customer customer = new Customer(signupDto.getCustomerName(), signupDto.getCustomerAge(), signupDto.getCustomerEmail(), encryptedPassword, signupDto.getCustomerMobileNumber(), signupDto.getCustomerAddress(),signupDto.getCustomerCity(), signupDto.getCustomerState(),signupDto.getCustomerCountry(), signupDto.getCustomerPincode());

        Customer createdCustomer;
        try {
          
            createdCustomer = customerRepository.save(customer);
           
            final AuthenticationToken authenticationToken = new AuthenticationToken(createdCustomer);
           
            authenticationService.saveConfirmationToken(authenticationToken);
          
            return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
        } catch (Exception e) {
           
            throw new CustomException(e.getMessage());
        }
    }

    public SignInResponseDto signIn(SignInDto signInDto) throws CustomException {

    	Customer customer = customerRepository.findByCustomerEmail(signInDto.getCustomerEmail());
        if(!Helper.notNull(customer)){
            throw  new AuthenticationFailException("Customer not present");
        }
        try {
          
            if (!customer.getCustomerPassword().equals(hashPassword(signInDto.getCustomerPassword()))){
            
                throw  new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(customer);
  
        

        if(!Helper.notNull(token)) {
            
            throw new CustomException("token not present");
        }
        Customer customer1 =customerRepository.findByCustomerEmail(signInDto.getCustomerEmail());

        return new SignInResponseDto ("success", token.getToken(),customer1.getCustomerName());
    }


    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }

//    public ResponseDto createUser(String token, UserCreateDto userCreateDto) throws CustomException, AuthenticationFailException {
//        User creatingUser = authenticationService.getUser(token);
//        if (!canCrudUser(creatingUser.getRole())) {
//            // user can't create new user
//            throw  new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
//        }
//        String encryptedPassword = userCreateDto.getPassword();
//        try {
//            encryptedPassword = hashPassword(userCreateDto.getPassword());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            logger.error("hashing password failed {}", e.getMessage());
//        }
//
//        User user = new User(userCreateDto.getFirstName(), userCreateDto.getLastName(), userCreateDto.getEmail(), userCreateDto.getRole(), encryptedPassword );
//        User createdUser;
//        try {
//            createdUser = userRepository.save(user);
//            final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
//            authenticationService.saveConfirmationToken(authenticationToken);
//            return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
//        } catch (Exception e) {
//            // handle user creation fail error
//            throw new CustomException(e.getMessage());
//        }
//
//    }
//
//    boolean canCrudUser(Role role) {
//        if (role == Role.admin || role == Role.manager) {
//            return true;
//        }
//        return false;
//    }
//
//    boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
//        Role role = userUpdating.getRole();
//        // admin and manager can crud any user
//        if (role == Role.admin || role == Role.manager) {
//            return true;
//        }
//        // user can update his own record, but not his role
//        if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
//            return true;
//        }
//        return false;
//    }

}
