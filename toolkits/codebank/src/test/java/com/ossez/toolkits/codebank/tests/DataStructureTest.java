package com.ossez.toolkits.codebank.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Object of VariableOssez
 * 
 * @author YuCheng
 *
 */

class OssezVariable {
	int s1, s2;
	static int s3;

	OssezVariable(int x, int y, int z) {
		s1 = x;
		s2 = y;
		s3 = z;
	}
}

/**
 * @author YuCheng Hu
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DataStructureTest{

	private final static Logger logger = LoggerFactory.getLogger(DataStructureTest.class);


	@BeforeAll
	protected void setUp() throws Exception {
	}

	@AfterAll
	protected void tearDown() throws Exception {
	}


	/**
	 * Do RetsServerConnection Test
	 */
	@Test
	public void testArrayDataStructure() {

		int[] intArraySize = new int[3];
		Integer intArrayW[] = new Integer[3];
		logger.debug("Array Size - [{}]", intArraySize.length);
		logger.debug("Array Size - [{}]", intArrayW.length);

		int[] intArrayValue = {1,2,3};
		String[] strArray = {"COM","OSSEZ","US"};
		logger.debug("Array Size - [{}]", intArrayValue.length);

	}

}
