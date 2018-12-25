package com.ossez.codebank.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author YuCheng
 *
 */
public class KayakRobotMovement {

	private final static Logger logger = LoggerFactory.getLogger(KayakRobotMovement.class);

	/**
	 * Get coordinates for Robot Movement
	 * 
	 * @param data
	 * @return
	 */
	public static String getCoordinates(String data) {
		logger.debug("BEGIN");

		String retStr = "";

		int x = 0;
		int y = 0;
		int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dir = 0;

		for (char ch : data.toCharArray()) {
			if (ch == 'F') {
				x += move[dir][0];
				y += move[dir][1];
			} else if (ch == 'L') {
				dir--;
			} else if (ch == 'R') {
				dir++;
			}
			dir = (dir + 4) % 4;
		}
		retStr = x + "," + y;

		return retStr;
	}
}
