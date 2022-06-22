package com.style.algorithm.skill;

/**
 * @author leon
 * @date 2021-12-18 17:51:39
 */
public class NumArray {

    private final Integer[] preSum;

    public NumArray(Integer[] sum) {
        int length = sum.length;

        preSum = new Integer[length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + sum[i - 1];
        }
    }

    public Integer sumRange(Integer left, Integer right) {
        int i = right + 1;
        int index = preSum[i];
        Integer integer = preSum[right + 1];
        Integer leftVal = preSum[left];
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        Integer sum1 = numArray.sumRange(2, 5);
        Integer sum2 = numArray.sumRange(0, 5);
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
