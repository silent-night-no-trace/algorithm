package com.style.algorithm.problemset;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. 优势洗牌
 *
 * @author leon
 * @date 2021-12-28 16:46:02
 */
public class Solution870 {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] x, int[] y) -> y[1] - x[1]);

        //给nums2降序
        for (int i = 0; i < length; i++) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }
        //定义搜索区间
        int left = 0, right = length - 1;
        //定义返回结果
        int[] res = new int[length];
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int i = poll[0];
            int maxVal = poll[1];
            if (nums1[right] > maxVal) {
                //田鸡的🐴大于 敌人的🐴
                //直接赋值
                res[i] = nums1[right];
                right--;
            } else if (nums1[left] <= maxVal) {
                //田鸡的🐴 小于敌人的🐴
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] ints = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
