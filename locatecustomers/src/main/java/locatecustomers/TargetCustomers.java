package locatecustomers;

import java.util.Collections;
import java.util.List;

public class TargetCustomers {

	public static void main(String[] args) {
		
		/*
		 * Get all our customers and check if they are within the perimiter of the office.
		 * Print out the results of those who are.
		 */
		
		List<Customer> allCustomers = RecordHelper.getAllCustomers();
		System.out.println("Found " + allCustomers.size() + " customers in total");
		
		List<Customer> customersWithinRadius = CoordinatesHelper.findCustomersWithinOfficeRadius(allCustomers);
		System.out.println("Customers within radius of office: " + customersWithinRadius.size());
		
		// sort by user ID, as per requirements, and print results
		Collections.sort(customersWithinRadius);
		for (Customer luckyCustomer : customersWithinRadius) {
			System.out.println(luckyCustomer);
		}
	}

}
