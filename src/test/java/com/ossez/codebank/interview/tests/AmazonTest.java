package com.ossez.codebank.interview.tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Amazon
 * 
 * <pre>
 * https://www.cwiki.us/display/ITCLASSIFICATION/Flatten+Nested+Arrays
 * </pre>
 * 
 * @author YuCheng
 *
 */
public class AmazonTest {

	private final static Logger logger = LoggerFactory.getLogger(AmazonTest.class);

	List<Integer> returnList = new ArrayList<Integer>();

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Flatten+Nested+Arrays
	 * 
	 * FlattenNestedArrays
	 */
	@Test
	public void testFlattenNestedArrays() {
		logger.debug("Test FlattenNestedArrays");
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<List<Integer>>();
		List<Integer> a1 = new ArrayList<Integer>();
		List<Integer> a2 = new ArrayList<Integer>();
		List<Integer> a3 = new ArrayList<Integer>();

		a1.add(1);
		a1.add(0);
		a1.add(0);

		a2.add(1);
		a2.add(0);
		a2.add(0);

		a3.add(1);
		a3.add(9);
		a3.add(1);
		area.add(a1);
		area.add(a2);
		area.add(a3);

		int countD = 0;

		int x = 0;
		int y = 0;

		for (int i = 0; i < area.size(); i++) {
			boolean found9 = false;
			y = 0;

			List<Integer> xList = area.get(i);
			for (int j = 0; j < xList.size(); j++) {
				if (xList.get(j) != 9) {
					y++;
				} else {
					found9 = true;
					break;
				}

			}

			if (found9) {
				break;
			}

			x++;

		}

		int carX = 0;
		int carY = 0;

		for (int k = 0; k < numRows * numRows; k++) {

			String command = makeMove(carX, carY, numRows, numColumns, area);

			if (command != null) {

				if (command.equals("U")) {
					carY = carY + 1;
				}
				if (command.equals("R")) {
					carX = carX + 1;
				}
				if (command.equals("L")) {
					carX = carX - 1;
				}
				if (command.equals("D")) {
					carY = carY + 1;
				}

				countD = countD + 1;

				if (carX == x && carY == y) {
					break;
				}
			} else {
				break;
			}
		}

		System.out.println("---" + x + y);
		System.out.println("--COUNT-" + countD );

	}

	/**
	 * Java 8 Stream to Flatten array.
	 * 
	 * @param array
	 * @return
	 */
	private static String makeMove(int carX, int carY, int numRows, int numColumns, List<List<Integer>> area) {
		
	

		if ((carX + 1 <numRows) && area.get(carX + 1).get(carY) !=9 )
			if (area.get(carX + 1).get(carY) == 1)
				return "R";
			else
				return "F";
		
		
		if ((carY + 1 <numColumns) && area.get(carX + 1).get(carY) !=9)
			if (area.get(carX).get(carY + 1) == 1)
				return "U";
			else
				return "F";

		if (carX > 0 && area.get(carX + 1).get(carY) !=9 )
			if (area.get(carX - 1).get(carY) == 1)
				return "L";
			else
				return "F";

		else if (carX > 0 && carY > 0 && area.get(carX - 1).get(carY - 1) == 1)
			return "D";

		return null;
	}

	/**
	 * Loop And Recursive
	 * 
	 * @param inputArray
	 * @return
	 * @throws IllegalArgumentException
	 */
	private List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants, List<List<Integer>> allLocations, int numRestaurants) {
		// WRITE YOUR CODE HERE

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		HashMap<Double, List<Integer>> mp = new HashMap<Double, List<Integer>>();
		Double[] keyArray = new Double[totalRestaurants];

		int i = 0;
		for (List<Integer> al : allLocations) {
			Double dis = getDis(al.get(0), al.get(1));
			mp.put(dis, al);
			keyArray[i] = dis;

			i++;
		}

		Arrays.sort(keyArray);
		for (int j = 0; j < numRestaurants; j++) {
			ret.add(mp.get(keyArray[j]));
		}

		return null;
	}

	private Double getDis(int a, int b) {
		// WRITE YOUR CODE HERE

		return Math.sqrt(a * a + b * b);

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
