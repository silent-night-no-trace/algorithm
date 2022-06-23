package com.style.algorithm.problemset;

import com.style.algorithm.skill.Difference;

/**
 * 拼车问题 1094
 *
 * @author leon
 * @date 2021-12-21 23:01:46
 */
public class Solution1094 {

	/**
	 * 是否可以拼成功
	 * 你是⼀个开公交⻋的司机，公交⻋的最⼤载客量为 capacity，沿途要经过若⼲⻋站，给你⼀份乘客⾏程表
	 * int[][] trips，其中 trips[i] = [num, start, end] 代表着有 num 个旅客要从站点 start 上⻋，
	 * 到站点 end 下⻋，请你计算是否能够⼀次把所有旅客运送完毕（不能超过最⼤载客量 capacity）。
	 * 注意细节点 上车点i 下车点 j 真实坐在车上时间点 i ,j -1
	 *
	 * @param trips    trips
	 * @param capacity capacity
	 * @return boolean
	 */
	public boolean carPooling(int[][] trips, int capacity) {
		int[] nums = new int[1001];
		Difference difference = new Difference(nums);
		for (int[] trip : trips) {
			//乘客数量
			int val = trip[0];
			//第 trip[1] 站乘客上⻋
			int start = trip[1];
			// 第 trip[2] 站乘客已经下⻋，
			// 即乘客在⻋上的区间是 [trip[1], trip[2] - 1]
			int end = trip[2] - 1;
			difference.increment(start, end, val);
		}
		//获取结果
		int[] result = difference.result();
		for (int res : result) {
			if (res > capacity) {
				return false;
			}
		}
		return true;
	}
}

