package com.ossez.lang.tutorial.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

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
 * 
 * @author YuCheng
 *
 */
public class VariableTest extends TestCase {

	private final static Logger logger = LoggerFactory.getLogger(VariableTest.class);

	/**
	 * Do RetsServerConnection Test
	 */
	@Test
	public void testStaticVariableChange() {

		OssezVariable objA = new OssezVariable(1, 2, 3);
		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objA.s1, objA.s2, OssezVariable.s3);

		OssezVariable objB = new OssezVariable(4, 5, 6);
		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objA.s1, objA.s2, OssezVariable.s3);
		logger.debug("s1/s2/s3 - [{}]/[{}]/[{}]", objB.s1, objB.s2, OssezVariable.s3);
	}

}
