package locatecustomers;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesHelper {
	
	// office coordinates
	public static final Double INTERCOM_LAT = 53.3381985;
	public static final Double INTERCOM_LONG = -6.2592576;
	
	// looking to target customers in this radius
	public static final Double RADIUS_METERS = 1100000.0;
	
	
	/**
	 * Coordinates of Intercom's Dublin office
	 * @return Coordinate object with the latitude and longitude
	 */
	public static Coordinates getIntercomBase() {
		return new Coordinates(INTERCOM_LAT, INTERCOM_LONG);
	}
	
	/**
	 * Checks the list of all customers and returns a new list of those customers within the radius
	 * @param allCustomers
	 * @return
	 */
	public static List<Customer> findCustomersWithinOfficeRadius(List<Customer> allCustomers) {
		
		List<Customer> customersWithinRadius = new ArrayList<Customer>();
		
		for (Customer customer : allCustomers) {
			if (isCustomerWithinOfficeRadius(customer.getCoordinates())) {
				customersWithinRadius.add(customer);
			}
		}
		
		return customersWithinRadius;
	}
	
	/**
	 * For the specified customer, are they within the specified radius of the Intercom office?
	 * @param customer's coordinates
	 * @return whether the customer is within the radius of the office or not
	 */
	public static boolean isCustomerWithinOfficeRadius(Coordinates customerLocation) {
		boolean withinRadius = false;
		
		if (calculateDistanceFromOffice(customerLocation) <= RADIUS_METERS) {
			withinRadius = true;
		}
		
		return withinRadius;
	}
	
	/**
	 * Calculate the given customer's distance from the office
	 * @param customerLocation
	 * @return distance between office and customer location in meters
	 */
	public static double calculateDistanceFromOffice(Coordinates customerLocation) {
		
		// using the first formula here: https://en.wikipedia.org/wiki/Great-circle_distance
		// Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		
		double x1 = Math.toRadians(INTERCOM_LAT);
		double y1 = Math.toRadians(INTERCOM_LONG);
		
		double x2 = Math.toRadians(customerLocation.getLatitude());
		double y2 = Math.toRadians(customerLocation.getLongitude());
		
		double centralAngleRadians = Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		
		// the radius of the earth is 6,371km
		double distance = 6371000 * Math.toDegrees(centralAngleRadians);
		
		return distance;
	}
}
