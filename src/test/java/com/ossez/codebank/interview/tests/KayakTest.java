package com.ossez.codebank.interview.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ossez.codebank.interview.KayakRobotMovement;

/**
 * 
 * @author YuCheng
 *
 */
public class KayakTest {

	private final static Logger logger = LoggerFactory.getLogger(KayakTest.class);

	/**
	 * testGetCoordinates
	 */
	@Test
	public void testGetCoordinates() {
		logger.debug("TEST Get Coordinat ");
		logger.debug("LFFF - [{}]", KayakRobotMovement.getCoordinates("LFFF"));

		assertEquals(KayakRobotMovement.getCoordinates("FF"), "0,2");
		assertEquals(KayakRobotMovement.getCoordinates("LFFFRFFFRRFFF"), "-3,0");

	}

}
