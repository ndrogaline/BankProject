package mypack.services;

import java.util.*;

import mypack.models.Customer;
import mypack.utilities.InitialData;

public class CustomerService {
	
	
	public Customer getCustomerById(int id){
		List<Customer> customers = 	InitialData.customers;
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	
}
