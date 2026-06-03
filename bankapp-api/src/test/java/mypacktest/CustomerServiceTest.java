package mypacktest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

import mypack.models.Customer;
import mypack.services.CustomerService;
import mypack.utilities.InitialData;

public class CustomerServiceTest {
    
	List<Customer> customers = InitialData.customers;
	
	@Test
	public void getCustomerById_Success_Test() {
		CustomerService customerService = new CustomerService();
		int id = 1;
		Customer actualResult = customerService.getCustomerById(id);
		Customer expectedResult = customers.get(0);
		
		assertEquals(actualResult, expectedResult);
	}
	

	@Test
	public void getCustomerById_Fail_Test() {
		CustomerService customerService = new CustomerService();
		int id = 100;
		Customer actualResult = customerService.getCustomerById(id);
		Customer expectedResult = null;
		
		assertEquals(actualResult, expectedResult);
	}
}
