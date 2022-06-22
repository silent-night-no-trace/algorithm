package com.style.algorithm.problemset;

/**
 * 26. 删除有序数组中的重复项
 *
 * @author leon
 * @date 2021-12-29 10:10:22
 */
public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            //不一样 说明不重复
            if (nums[fast] != nums[slow]) {
                System.out.println("前slow:" + slow);
                slow++;
                //维护 nums 在 [0,slow]的数组不重复
                System.out.println("后slow:" + slow);
                System.out.println("后fast:" + fast);
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 2, 3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
