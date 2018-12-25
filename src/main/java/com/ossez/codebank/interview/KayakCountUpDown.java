package com.ossez.codebank.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author YuCheng
 *
 */
public class KayakCountUpDown {

	static int minNumber = 0;
	static int maxNumber = 0;
	int tmpN = 0;
	List<Integer> retList = new ArrayList<Integer>();

	public List<Integer> countUp(int start, int end) {
		maxNumber = end;
		tmpN = start;
		moveUp(0);
		retList.add(end);
		return retList;

	}

	public List<Integer> countUpDown(int start, int end) {
		minNumber = start;
		maxNumber = end;
		tmpN = start;
		
		moveUp(0);
		retList.add(end);
		
		moveDown(1);
		return retList;
	
	}

	private void moveUp(int n) {
		retList.add(tmpN);
		tmpN++;
		if (tmpN != maxNumber) {
			moveUp(tmpN + 1);
		}

	}

	private void moveDown(int n) {
		tmpN = (maxNumber - n );
		retList.add(tmpN);

		if (tmpN != minNumber) {
			moveDown(n + 1);
		}
	}

}
