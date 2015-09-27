package locatecustomers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void testCustomerSorting() throws Exception {
		Customer c1 = new Customer(4, "Name1", 4, -4);
		Customer c2 = new Customer(1, "Name1", 1, -1);
		Customer c3 = new Customer(5, "Name1", 5, -5);
		Customer c4 = new Customer(2, "Name1", 2, -2);
		Customer c5 = new Customer(3, "Name1", 3.0, -3.0);
		Customer c6 = new Customer(3, "Name1", 3.1, -3.1);
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		
		Collections.sort(customers);
		System.out.println(customers);
		
		String expected = "[[1] Name1 (1.0, -1.0), [2] Name1 (2.0, -2.0), [3] Name1 (3.0, -3.0), [3] Name1 (3.1, -3.1), [4] Name1 (4.0, -4.0), [5] Name1 (5.0, -5.0)]";
		Assert.assertEquals("Sorted array not as expected", expected, customers.toString());
	}

}
