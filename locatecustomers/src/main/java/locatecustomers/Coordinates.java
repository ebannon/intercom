package locatecustomers;

public class Coordinates {
	
	/*
	 * Stack Overflow debates the use of double compared to BigDecimal
	 * but a double should be OK for our requirements here.
	 */
	
	private double latitude;
	private double longitude;
	
	
	public Coordinates(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	
	public String toString() {
		return "(" + latitude + ", " + longitude + ")";
	}

}
