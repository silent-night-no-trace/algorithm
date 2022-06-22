package com.style.algorithm.problemset;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 *
 * @author leon
 * @date 2021-12-29 13:49:27
 */
@SuppressWarnings("all")
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }
        int i = removeElement(nums, 0);
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                //先赋值 在slow++
                //保证 [0,slow-1] 不包含 val
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 0, 1, 23, 4};
        moveZeroes(nums);
    }
}
