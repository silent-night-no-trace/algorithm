package com.style.algorithm.problemset;

import com.style.algorithm.skill.MonotonicQueue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 *
 * @author leon
 * @date 2022-01-04 17:09:05
 */
public class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        int length = nums.length;

        ArrayList<Integer> maxArrayList = new ArrayList<>();
        //单调队列结构
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        for (int i = 0; i < length; i++) {
            if (i < k - 1) {
                //索引从0开始 故要小于k-1
                //不够窗口大小 则一直移动添加
                monotonicQueue.push(nums[i]);
            } else {
                //大于等于窗口大小 移动一位
                monotonicQueue.push(nums[i]);
                //添加窗口最值
                maxArrayList.add(monotonicQueue.max());
                //将窗口末端 移除
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        int size = maxArrayList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = maxArrayList.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
