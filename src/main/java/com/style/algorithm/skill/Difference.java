package com.style.algorithm.skill;

import java.util.Arrays;

/**
 * 差分数工具类
 *
 * @author leon
 * @date 2021-12-21 16:34:36
 */
public class Difference {

	private int[] diff;

	public Difference(int[] nums) {
		if (null == nums) {
			return;
		}

		int length = nums.length;
		if (length <= 0) {
			return;
		}
		diff = new int[length];
		diff[0] = nums[0];
		for (int i = 1; i < length; i++) {
			diff[i] = nums[i] - nums[i - 1];
		}
	}


	/**
	 * 给i到j 增加 val
	 *
	 * @param i   i
	 * @param j   j
	 * @param val val
	 */
	public void increment(int i, int j, int val) {
		diff[i] += val;
		if (j + 1 < diff.length) {
			//j + 1 >= diff.length 标识对整个数组修改 不需要在-val
			diff[j + 1] -= val;
		}
	}

	public int[] result() {
		int length = diff.length;
		int[] result = new int[diff.length];
		//初始化值
		result[0] = diff[0];
		for (int i = 1; i < length; i++) {
			result[i] = result[i - 1] + diff[i];
		}
		return result;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int[] num2 = {8, -3, 4, -3, 5};

		Difference difference = new Difference(nums);
		difference.increment(1, 4, 2);
		int[] result = difference.result();
		System.out.println(Arrays.toString(result));
	}

}
