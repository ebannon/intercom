package locatecustomers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RecordHelper {
	
	public static final String CUSTOMER_FILE = "customers.json";
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	
	/**
	 * Parse the provided JSON file of customer data and store in a list of Customers
	 * @return list of all customers
	 */
	public static List<Customer> getAllCustomers() {
		
		// storing all customers in this list after parsing the JSON
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			//String test = getClass().getResource("/" + CUSTOMER_FILE).toString();
			fileReader = new FileReader("/home/eric/workspace/locatecustomers/target/classes/customers.json");
			bufferedReader = new BufferedReader(fileReader);
			JSONParser parser = new JSONParser();
			
			String currentLine = "";
			while ( (currentLine = bufferedReader.readLine()) != null) {
				JSONObject jsonObject = (JSONObject) parser.parse(currentLine);
				customers.add(createCustomerFromJson(jsonObject));
			}
		}
		catch (FileNotFoundException ex) {
			System.err.println("Customer file not found: " + CUSTOMER_FILE);
			ex.printStackTrace();
		}
		catch (ParseException ex) {
			System.err.println("Error parsing the data in file:  " + CUSTOMER_FILE);
			ex.printStackTrace();
		}
		catch (IOException ex) {
			System.err.println("An I/O exception occurred when reading file: " + CUSTOMER_FILE);
		}
		finally {
			cleanUp();
		}
		
		return customers;
	}
	
	/**
	 * Extract the desired fields (keys) from current line in the JSON file 
	 * and return in the form of a Customer object.
	 * @param jsonLine - the current line in the JSON file
	 * @return Customer object with ID, full name and coordinates
	 */
	private static Customer createCustomerFromJson(JSONObject jsonLine) {
		
		// auto-boxing doesn't work for String -> Double here so parsing values as Strings instead
		long customerId = (Long) jsonLine.get("user_id");
		String fullName = (String) 	jsonLine.get("name");
		double latitude = Double.parseDouble((String) jsonLine.get("latitude"));
		double longitude = Double.parseDouble((String) jsonLine.get("longitude"));
		
		return new Customer(customerId, fullName, latitude, longitude);
	}
	
	/**
	 * Tidy up after working with files
	 */
	private static void cleanUp() {
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException ex) {
			System.err.println("Error occurred when cleaning up");
		}
	}

}
