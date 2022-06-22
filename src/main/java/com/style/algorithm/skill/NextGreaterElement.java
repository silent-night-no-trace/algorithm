package com.style.algorithm.skill;

import java.util.Stack;

/**
 * 下一个 最大的元素
 * 变种
 * com.style.algorithm.problemset.Solution739
 *
 * @author leon
 * @date 2021-12-31 16:50:52
 */
@SuppressWarnings("all")
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums) {
        if (null == nums) {
            return null;
        }
        int length = nums.length;
        if (length <= 0) {
            return null;
        }
        //定义结果
        int[] res = new int[length];
        //
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                //移除小的
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }
}
