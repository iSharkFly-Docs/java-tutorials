package com.ossez.codebank.interview;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * https://www.cwiki.us/display/ITCLASSIFICATION/Count+Up+Down
 * 
 * @author YuCheng
 *
 */
public class KayakCountUpDown {
	private final static Logger logger = LoggerFactory.getLogger(KayakCountUpDown.class);

	static int minNumber = 0;
	static int maxNumber = 0;
	int tmpN = 0;
	List<Integer> retList = new ArrayList<Integer>();

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Integer> countUp(int start, int end) {
		logger.debug("BEGIN");
		maxNumber = end;
		tmpN = start;
		moveUp(0);
		retList.add(end);
		return retList;

	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Integer> countUpDown(int start, int end) {
		logger.debug("BEGIN");
		minNumber = start;
		maxNumber = end;
		tmpN = start;

		moveUp(0);
		retList.add(end);

		moveDown(1);
		return retList;

	}

	/**
	 * 
	 * @param n
	 */
	private void moveUp(int n) {
		retList.add(tmpN);
		tmpN++;
		if (tmpN != maxNumber) {
			moveUp(tmpN + 1);
		}

	}

	/**
	 * 
	 * @param n
	 */
	private void moveDown(int n) {
		tmpN = (maxNumber - n);
		retList.add(tmpN);

		if (tmpN != minNumber) {
			moveDown(n + 1);
		}
	}

}
