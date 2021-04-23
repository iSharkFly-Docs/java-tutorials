package com.ossez.codebank.interview.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.interview.KayakCountUpDown;
import com.ossez.codebank.interview.KayakRobotMovement;

/**
 * 
 * @author YuCheng
 *
 */
public class KayakTest {

	private final static Logger logger = LoggerFactory.getLogger(KayakTest.class);

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Robot+Movement
	 * 
	 * testGetCoordinates
	 * 
	 */
	@Test
	public void testGetCoordinates() {
		logger.debug("TEST Get Coordinat ");
		logger.debug("LFFF - [{}]", KayakRobotMovement.getCoordinates("FF"));
		logger.debug("LFFFRFFFRRFFF - [{}]", KayakRobotMovement.getCoordinates("LFFFRFFFRRFFF"));

		assertEquals(KayakRobotMovement.getCoordinates("FF"), "0,2");
		assertEquals(KayakRobotMovement.getCoordinates("LFFFRFFFRRFFF"), "-3,0");

	}

	/**
	 * https://www.cwiki.us/display/ITCLASSIFICATION/Count+Up+Down
	 * 
	 * CountUpDown
	 */
	@Test
	public void testCountUpDown() {
		logger.debug("TEST Count Up and Down ");

		// 2 -5
		logger.debug("[2 -> 5]");
		logger.debug("UP - {}", new KayakCountUpDown().countUp(2, 5));
		logger.debug("UP & DOWN - {}", new KayakCountUpDown().countUpDown(2, 5));

		// 0 - 5
		logger.debug("[0 -> 5]");
		logger.debug("UP - {}", new KayakCountUpDown().countUp(0, 5));
		logger.debug("UP & DOWN - {}", new KayakCountUpDown().countUpDown(0, 5));

		// -1 - 5
		logger.debug("[-1 -> 5]");
		logger.debug("UP - {}", new KayakCountUpDown().countUp(-1, 5));
		logger.debug("UP & DOWN - {}", new KayakCountUpDown().countUpDown(-1, 5));

	}

}
