package com.ossez.codebank.interview.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.interview.KayakCountUpDown;
import com.ossez.codebank.interview.KayakRobotMovement;

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
		logger.debug("{} - > {}", Arrays.deepToString(array), Arrays.toString(java8Flatten(array).toArray()));

	}

	/**
	 * Java 8 Stream to Flatten array.
	 * 
	 * @param array
	 * @return
	 */
	private static Stream<Object> java8Flatten(Object[] array) {
		return Arrays.stream(array).flatMap(o -> o instanceof Object[] ? java8Flatten((Object[]) o) : Stream.of(o));
	}

}
