package utilities;

import java.util.*;

import com.example.demo.models.*;

public class AllData {
   public static List<Customer> customers = new ArrayList<>();
   
   static {
   	   customers.add(new Customer(1, "John Doe"));
	   customers.add(new Customer(2, "Jane Smith"));
	   customers.add(new Customer(3, "Alice Johnson"));
   }
}
