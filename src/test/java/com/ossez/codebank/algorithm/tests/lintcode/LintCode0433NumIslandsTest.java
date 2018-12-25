package com.ossez.codebank.algorithm.tests.lintcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 433
 * <ul>
 * <li>@see <a href=
 * "https://www.cwiki.us/display/ITCLASSIFICATION/Number+of+Islands">https://www.cwiki.us/display/ITCLASSIFICATION/Number+of+Islands</a>
 * <li>@see<a href="https://www.lintcode.com/problem/number-of-islands/">https://www.lintcode.com/problem/number-of-islands/</a>
 * </ul>
 * </p>
 * 
 * @author YuCheng
 *
 */
public class LintCode0433NumIslandsTest {

	private final static Logger logger = LoggerFactory.getLogger(LintCode0433NumIslandsTest.class);

	/**
	 * 
	 */
	@Test
	public void testMain() {
		logger.debug("BEGIN");
		// INIT GRID
		boolean[][] grid = { { true, true, false, false, false }, { false, true, false, false, true }, { false, false, false, true, true },
				{ false, false, false, false, false }, { false, false, false, false, true }

		};

		// NULL CHECK
		if (grid.length == 0 || grid[0].length == 0) {
			System.out.println("NULL");
			// return 0;
		}

		// GET SIZE
		int n = grid.length;
		int m = grid[0].length;

		// ARRAY FOR VISITED LOG
		boolean[][] visited = new boolean[n][m];

		int count = 0;

		// LOOP FOR GRID
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] && !visited[i][j]) {
					numIslandsDFS(grid, visited, i, j);
					count++;
				}
			}
		}

		System.out.println(count);

	}

	/**
	 * 
	 * @param grid
	 * @param visited
	 * @param x
	 * @param y
	 */
	public void numIslandsDFS(boolean[][] grid, boolean[][] visited, int x, int y) {
		if (x < 0 || x >= grid.length) {
			return;
		}

		if (y < 0 || y >= grid[0].length) {
			return;
		}

		if (grid[x][y] != true || visited[x][y]) {
			return;
		}

		visited[x][y] = true;

		// Recursive call
		numIslandsDFS(grid, visited, x - 1, y);
		numIslandsDFS(grid, visited, x + 1, y);
		numIslandsDFS(grid, visited, x, y - 1);
		numIslandsDFS(grid, visited, x, y + 1);

	}
}
