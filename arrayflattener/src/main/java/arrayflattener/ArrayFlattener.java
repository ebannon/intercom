package arrayflattener;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {
	
	
	/**
	 * Flatten an array of arbitrary nested arrays of integers into a flat array of integers, 
	 * e.g. [[1,2,[3]],4] -> [1,2,3,4]
	 * @param unflattened array of type Object (each element can in turn be an integer or another array of integers)
	 * @return a single array with all provided integer values flattened
	 */
	public static Integer[] flatten(Object[] unflattened) {
		List<Integer> flattenedArray = new ArrayList<Integer>();
		
		return flatten(unflattened, flattenedArray);
	}
	
	
	private static Integer[] flatten(Object[] unflattened, List<Integer> flattenedArray) {
		
		/*
		 * Loop through each element in the array. 
		 * If it's an integer, we can simply add it to the final list.
		 * But if it's another array of numbers, we'll need to break that down first - recursively.
		 * We don't support other types right now *sadface*
		 */
		
		if (flattenedArray != null) {
			for (int i = 0; i < unflattened.length; i++) {
				
				if (unflattened[i] instanceof Integer) {
					flattenedArray.add((Integer) unflattened[i]);
				}
				else if (unflattened[i] instanceof Integer[]) {
					flatten((Object[]) unflattened[i], flattenedArray);
				}
				else {
					throw new IllegalArgumentException("Only arrays of integers are supported");
				}
			}
		}
		
		return flattenedArray.toArray(new Integer[flattenedArray.size()]);
	}

}
