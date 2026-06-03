package mypack.utilities;

import java.util.*;

import mypack.models.Customer;

public class InitialData {
      public static List<Customer> customers = new ArrayList<>();
      
      static {
    	  Customer c1 = new Customer(1,"rohit");
    	  Customer c2 = new Customer(2,"mohit");
    	  Customer c3 = new Customer(3,"shbohit");
    	  customers.add(c1); customers.add(c2); customers.add(c3);
      }
}
