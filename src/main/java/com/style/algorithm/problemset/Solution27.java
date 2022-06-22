package com.style.algorithm.problemset;

/**
 * 27 移除元素
 *
 * @author leon
 * @date 2021-12-29 11:20:50
 */
public class Solution27 {

    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                //先赋值 在移动 slow
                //我们这⾥是先给 nums[slow] 赋值然后再给 slow++，这 样可以保证 nums[0..slow-1] 是不包含值为 val 的元素的，最后的结果数组⻓度就是 slow。
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 2, 3};
        int i = removeElement(nums,1);
        System.out.println(i);
    }
}
