package com.style.algorithm.problemset;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author leon
 * @date 2021-12-27 16:54:03
 */
@SuppressWarnings("all")
public class Solution34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
        int[] ints2 = searchRange(nums, 6);
        System.out.println(Arrays.toString(ints2));

    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    public static int leftBound(int[] nums, int target) {
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
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                right = mid - 1;
            }
        }
        if (left >= length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private static int rightBound(int[] nums, int target) {
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
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


}
