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

}
