package com.ossez.codebank.interview.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PillPack
 * 
 * <pre>
 * https://www.cwiki.us/display/ITCLASSIFICATION/Flatten+Nested+Arrays
 * </pre>
 * 
 * @author YuCheng
 *
 */
public class PillPackTest {

	private final static Logger logger = LoggerFactory.getLogger(PillPackTest.class);

	List<Integer> returnList = new ArrayList<Integer>();

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Flatten+Nested+Arrays
	 * 
	 * FlattenNestedArrays
	 */
	@Test
	public void testFlattenNestedArrays() {
		logger.debug("Test FlattenNestedArrays");

		Object[] array = { 1, 2, new Object[] { 3, 4, new Object[] { 5, new Object[] { new Object[] { 6 } } }, 7 }, 8, 9, 10 };
		logger.debug("LOOP: {} - > {}", Arrays.deepToString(array), Arrays.toString(loopFlatten(array)));

		logger.debug("Java 8: {} - > {}", Arrays.deepToString(array), Arrays.toString(java8Flatten(array).toArray()));

	}

	/**
	 * Loop And Recursive
	 * 
	 * @param inputArray
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static Integer[] loopFlatten(Object[] inputArray) throws IllegalArgumentException {
		// NULL CHECK
		if (inputArray == null)
			return null;

		List<Integer> flatList = new ArrayList<Integer>();

		for (Object element : inputArray) {
			if (element instanceof Integer) {
				flatList.add((Integer) element);
			} else if (element instanceof Object[]) {
				// Recursive
				flatList.addAll(Arrays.asList(loopFlatten((Object[]) element)));
			} else {
				throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
			}
		}
		return flatList.toArray(new Integer[flatList.size()]);
	}

	/**
	 * Java 8 Stream to Flatten array.
	 * 
	 * @param array
	 * @return
	 */
	private static Stream<Object> java8Flatten(Object[] array) {
		// int[] flatInt = java8Flatten(array).mapToInt(Integer.class::cast).toArray();
		return Arrays.stream(array).flatMap(o -> o instanceof Object[] ? java8Flatten((Object[]) o) : Stream.of(o));

	}

}
