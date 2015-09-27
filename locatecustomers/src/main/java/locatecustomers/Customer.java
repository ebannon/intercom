package locatecustomers;

public class Customer implements Comparable<Customer> {
	
	private long id;
	private String fullName;
	private Coordinates coordinates;
	
	public Customer(long id, String fullName, double latitude, double longitude) {
		this.id = id;
		this.fullName = fullName;
		this.coordinates = new Coordinates(latitude, longitude);
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}


	public String toString() {
		return "[" + id + "] " + fullName + " " + coordinates.toString();
	}


	public int compareTo(Customer customer) {
		// need to sort results by customer ID
		return (id < customer.getId()) ? -1 : 1;
	}
	
}
