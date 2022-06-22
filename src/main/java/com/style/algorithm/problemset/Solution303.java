package com.style.algorithm.problemset;

import com.style.algorithm.skill.PrefixSum;

/**
 * 「区域和检索 - 数组不可变」
 *
 * @author leon
 * @date 2021-12-22 10:41:15
 */
public class Solution303 {

	private int[] perSum;

	public Solution303(int[] nums) {
		if (null == nums) {
			return;
		}
		int length = nums.length;
		if (length <= 0) {
			return;
		}
		//初始化前缀和 数组
		perSum = new int[length + 1];
		perSum[0] = 0;
		for (int i = 1; i <= length; i++) {
			perSum[i] = perSum[i - 1] + nums[i - 1];
		}
	}

	public int sumRange(int start, int end) {
		return perSum[end + 1] - perSum[start];
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

		Solution303 solution303 = new Solution303(nums);
		Integer sum = solution303.sumRange(0, 2);
		Integer sum1 = solution303.sumRange(2, 5);
		Integer sum2 = solution303.sumRange(0, 5);
		System.out.println(sum);
		System.out.println(sum1);
		System.out.println(sum2);


	}

	private void initNums(int[] nums) {
		int length = nums.length;
		if (length <= 0) {
			return;
		}
		//多出一个空间 存储一
		perSum = new int[length + 1];
		perSum[0] = 0;
		for (int i = 1; i <= length; i++) {
			perSum[i] = perSum[i - 1] + nums[i - 1];
		}
	}

	private int sum(int start, int end) {
		return perSum[end + 1] - perSum[start];
	}


}
