package locatecustomers;

import org.junit.Assert;
import org.junit.Test;

public class CoordinatesTest {
	
	@Test
	public void testDistanceWithinRadius() {
		Coordinates home = new Coordinates(53.44638819999999, -6.209576800000036);
		Coordinates galway = new Coordinates(53.55360340000001, -9.948231699999951);
		Coordinates belfast = new Coordinates(54.59728500000001, -5.930119999999988);
		Coordinates howth = new Coordinates(53.3858469, -6.0646842999999535);
		
		Assert.assertTrue("Home is within radius of office", CoordinatesHelper.isCustomerWithinOfficeRadius(home));
		Assert.assertFalse("Galway is not within radius of office", CoordinatesHelper.isCustomerWithinOfficeRadius(galway));
		Assert.assertFalse("Belfast is not within radius of office", CoordinatesHelper.isCustomerWithinOfficeRadius(belfast));
		Assert.assertTrue("Howth is within radius of office", CoordinatesHelper.isCustomerWithinOfficeRadius(howth));
	}

}
