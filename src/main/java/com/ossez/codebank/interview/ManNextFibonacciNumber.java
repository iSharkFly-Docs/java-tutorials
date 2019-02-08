package com.ossez.codebank.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * https://www.cwiki.us/display/ITCLASSIFICATION/Next+Fibonacci+Number
 * 
 * @author YuCheng
 *
 */
public class ManNextFibonacciNumber {
	private final static Logger logger = LoggerFactory.getLogger(ManNextFibonacciNumber.class);

	public static void main(String[] args) throws java.lang.Exception {
		int fArray[] = new int[60];

		for (int i = 0; i < 60; i++) {
			fArray[i] = getFib(i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// System.out.println(fib(Integer.valueOf(input)));

		for (int i = 0; i < Integer.valueOf(input); i++) {
			Integer inputInt = Integer.valueOf(br.readLine());
			// System.out.println(inputInt);
			for (int j = 0; j < fArray.length; j++) {
				if (fArray[j] > inputInt) {
					// System.out.println(fArray[j]);
					logger.debug("{} Next Fibonacci [{}]", inputInt, fArray[j]);
					break;
				}
			}

		}

	}

	/**
	 * Get Fibonacci Number
	 * 
	 * @param n
	 * @return
	 */
	private static int getFib(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			int[] fibAry = new int[n + 1];
			fibAry[0] = 0;
			fibAry[1] = fibAry[2] = 1;
			for (int i = 3; i <= n; i++) {
				fibAry[i] = fibAry[i - 1] + fibAry[i - 2];
			}
			return fibAry[n];
		}
	}
}
