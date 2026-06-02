package com.example.demo.repos;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Customer;

import utilities.AllData;

@Repository
public class CustomerRepository{
   //code that interacts with the database
	
	public List<Customer> getAllCustomers() {
		return AllData.customers;
		//Todo: code to get all customers from the database
	}

	public Customer getCustomerById(int id) {
		List<Customer> customers = AllData.customers;
		for(Customer customer : customers) {
			if(customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}
}
