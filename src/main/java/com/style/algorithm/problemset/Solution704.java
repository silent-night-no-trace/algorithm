package com.style.algorithm.problemset;

/**
 * 704 二分查找
 *
 * @author leon
 * @date 2021-12-27 15:54:31
 */
@SuppressWarnings("all")
public class Solution704 {

    public static int binarySearch(int[] nums, int target) {
        if (null == nums) {
            return -1;
        }
        int length = nums.length;
        if (0 == length) {
            return -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
