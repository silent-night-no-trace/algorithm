package com.style.algorithm.problemset;

/**
 * 矩阵和计算
 *
 * @author leon
 * @date 2021-12-21 09:26:10
 */
public class Solution304 {

	private int[][] preSums;

	public Solution304(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0 || n == 0) {
			return;
		}
		preSums = new int[m + 1][n + 1];
		//<=m 从1开始的
		for (int i = 1; i <= m; i++) {
			//<=n 从1开始
			for (int j = 1; j <= n; j++) {
				// 计算每个矩阵 [0, 0, i, j] 的元素和
				preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] + matrix[i - 1][j - 1] - preSums[i - 1][j - 1];
			}
		}

	}

	/**
	 * 计算和
	 * 1-----5
	 * 3-----1
	 *
	 * @param x1 row1
	 * @param y1 col1
	 * @param x2 row2
	 * @param y2 col2
	 * @return int
	 */

	public int sumRegion(int x1, int y1, int x2, int y2) {
		//5 -> x1 y2   3-> x2 y1
		return preSums[x2 + 1][y2 + 1] - preSums[x1][y2 + 1] - preSums[x2 + 1][y1] +
				preSums[x1][y1];
	}


	private void init(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		preSums = new int[m + 1][n + 1];
		//维护前缀数组
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//计算 [0,0,i,j ]
				preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] + matrix[i - 1][j - 1] - preSums[i - 1][j - 1];
			}
		}
	}

	private int sum(int x, int y, int x1, int y1) {
		//x1   y1
		//x2  y2

		return preSums[x1 + 1][y1 + 1] - preSums[x1 + 1][y] - preSums[x][y1 + 1] + preSums[x][y];
	}
}
