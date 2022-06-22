package com.style.algorithm.problemset;

import com.style.algorithm.skill.Difference;

/**
 * 拼车问题
 *
 * @author leon
 * @date 2021-12-21 23:01:46
 */
public class Solution1094 {

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

