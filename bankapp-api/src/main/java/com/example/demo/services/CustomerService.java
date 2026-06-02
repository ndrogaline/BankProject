package com.example.demo.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repos.CustomerRepository;

@Service
public class CustomerService {
   private CustomerRepository customerRepository;
 
  
   public CustomerService(CustomerRepository customerRepository) {
	   this.customerRepository = customerRepository;
   }
   
   public List<Customer> getAllCustomers(){
	   return customerRepository.getAllCustomers();
   }

   public Customer getCustomerById(int id) {
	return customerRepository.getCustomerById(id);
   }
}
