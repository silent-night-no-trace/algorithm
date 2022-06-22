package com.style.algorithm.skill;

/**
 * 前缀和
 *
 * @author leon
 * @date 2021-12-21 15:24:08
 */
public class PrefixSum {

    private int[] preSum;

    public PrefixSum(int[] nums) {
        if (null == nums) {
            return;
        }

        int length = nums.length;
        if (length <= 0) {
            return;
        }

        //前缀和数组
        preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }

    public static void main(String[] args) {
        int [] sums = {1,2,3,4,5};
        PrefixSum prefixSum = new PrefixSum(sums);
        int i = prefixSum.sumRange(1, 3);
        System.out.println(i);
    }

}
