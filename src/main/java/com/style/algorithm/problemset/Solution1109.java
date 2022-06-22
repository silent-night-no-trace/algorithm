package com.style.algorithm.problemset;

/**
 * 航班预定统计
 *
 * @author leon
 * @date 2021-12-21 22:41:17
 */
public class Solution1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int val = booking[2];
            difference.add(start, end, val);
        }
        return difference.result();
    }

    static class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            if (null == nums) {
                return;
            }
            int length = nums.length;
            if (length <= 0) {
                return;
            }
            //构造差值数组
            diff = new int[length];
            diff[0] = nums[0];
            for (int i = 1; i < length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void add(int start, int end, int val) {
            diff[start] += val;
            int length = diff.length;
            if (end + 1 < length) {
                diff[end + 1] -= val;
            }
        }

        public int[] result() {
            int length = diff.length;
            int[] result = new int[length];
            //初始化索引为0数据
            result[0] = diff[0];
            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] + diff[i];
            }
            return result;
        }
    }
}




