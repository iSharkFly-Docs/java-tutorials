package com.ossez.lang.tutorial.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Eager Singleton
 * 
 * @author YuCheng
 *
 */
class EagerSingleton {
	private static final EagerSingleton INSTANCE = new EagerSingleton();

	// Private constructor suppresses
	private EagerSingleton() {
	}

	// default public constructor
	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
}

/**
 * Lazy Singleton
 * 
 * @author YuCheng
 *
 */
class LazySingleton {
	private static volatile LazySingleton INSTANCE = null;

	// Private constructor suppresses
	// default LazySingleton constructor
	private LazySingleton() {
	}

	// thread safe and performance promote
	public static LazySingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (LazySingleton.class) {
				// when more than two threads run into the first null check same time, to avoid instanced more than one time, it needs to be
				// checked again.
				if (INSTANCE == null) {
					INSTANCE = new LazySingleton();
				}
			}
		}
		return INSTANCE;
	}
}

/**
 * 
 * @author YuCheng
 *
 */
public class SingletonTest {
	private final static Logger logger = LoggerFactory.getLogger(SingletonTest.class);

	@Test
	public void testSingleton() {
		logger.debug("TEST Singleton");

	}

}
