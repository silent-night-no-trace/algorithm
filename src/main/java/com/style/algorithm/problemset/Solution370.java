package com.style.algorithm.problemset;

import com.style.algorithm.skill.Difference;

import java.util.Arrays;

/**
 * 区间加法
 *
 * @author leon
 * @date 2021-12-21 18:19:38
 */
public class Solution370 {


	public static void main(String[] args) {
		int[][] nums = new int[3][3];
		nums[0] = new int[]{1, 3, 2};
		nums[1] = new int[]{2, 4, 3};
		nums[2] = new int[]{0, 2, -2};
		int[] modifiedArray = getModifiedArray(5, nums);
		System.out.println(Arrays.toString(modifiedArray));
	}

	public static int[] getModifiedArray(int length, int[][] nums) {
		int[] diff = new int[length];
		Difference difference = new Difference(diff);
		for (int[] num : nums) {
			int start = num[0];
			int end = num[1];
			int val = num[2];
			difference.increment(start, end, val);
		}
		return difference.result();
	}


	static class Differ {
		private int[] diff;

		public Differ(int[] nums) {
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

		public void add(int i, int j, int val) {
			int length = diff.length;

			diff[i] += val;
			if (j + 1 < length) {
				diff[j + 1] -= val;
			}
		}

		public int[] result() {
			int length = diff.length;
			int[] res = new int[length];
			res[0] = diff[0];
			for (int i = 1; i < length; i++) {
				res[i] = res[i - 1] + diff[i];
			}
			return res;
		}
	}
}
