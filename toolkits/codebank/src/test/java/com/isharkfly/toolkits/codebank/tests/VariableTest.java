package com.isharkfly.toolkits.codebank.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author YuCheng
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VariableTest extends TestCase {

	private final static Logger logger = LoggerFactory.getLogger(VariableTest.class);


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
	public void testStaticVariableChange() {

		OssezVariable objA = new OssezVariable(1, 2, 3);
		logger.debug("s1/s2/s3 - [{}]", Math.round(10.55));


		OssezVariable objB = new OssezVariable(4, 5, 6);
		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objA.s1, objA.s2, OssezVariable.s3);
		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objB.s1, objB.s2, OssezVariable.s3);
	}

}
