package arrayflattener;

import org.junit.Assert;
import org.junit.Test;


public class ArrayFlattenerTest {

	@Test
	public void testSimpleArray() throws Exception {
		Integer[] arrayToFlatten = new Integer[] {1, 2, 3};
		Integer[] flattenedArray = ArrayFlattener.flatten(arrayToFlatten);
		
		Assert.assertEquals("Array sizes did not match", 3, flattenedArray.length);
		Assert.assertArrayEquals("Flattened array not as expected", arrayToFlatten, flattenedArray);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArrayContentsWithString() throws Exception {
		Object[] arrayToFlatten = new Object[] {
				new Integer(1),
				new Integer(2),
				new String("unsupported object type - this will break"),
				new Integer(3)
				};
		
		Integer[] flattenedArray = ArrayFlattener.flatten(arrayToFlatten);
		Assert.assertNull("Flattening process should have failed", flattenedArray);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArrayContentsWithNull() throws Exception {
		Object[] arrayToFlatten = new Object[] {
				new Integer(1),
				new Integer(2),
				null,
				new Integer(3)
				};
		
		Integer[] flattenedArray = ArrayFlattener.flatten(arrayToFlatten);
		Assert.assertNull("Flattening process should have failed", flattenedArray);
	}
	
	@Test
	public void testEmptyArray() throws Exception {
		Object[] arrayToFlatten = new Object[] {};
		Integer[] flattenedArray = ArrayFlattener.flatten(arrayToFlatten);
		
		Assert.assertEquals("Array sizes did not match", 0, flattenedArray.length);
		Assert.assertArrayEquals("Flattened array not as expected", arrayToFlatten, flattenedArray);
	}
	
	@Test
	public void testNestedArray1() throws Exception {
		Integer[][] arrayToFlatten = new Integer[][] {{1}, {2, 3}, {4}, {5, 6, 7}, {8}};
		Integer[] flattenedArray = ArrayFlattener.flatten(arrayToFlatten);
		
		// need to pass around the flattened list to get this to work
		Assert.assertEquals("Array sizes did not match", 8, flattenedArray.length);
		Assert.assertArrayEquals("Flattened array not as expected", new Integer[] {1, 2, 3, 4, 5, 6, 7, 8}, flattenedArray);
	}

}
