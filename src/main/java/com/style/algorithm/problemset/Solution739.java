package com.style.algorithm.problemset;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * @author leon
 * @date 2021-12-31 16:02:19
 */
@SuppressWarnings("all")
public class Solution739 {
    //739. 每日温度
    //请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    //
    //示例 1:
    //
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出: [1,1,4,2,1,1,0,0]
    //示例 2:
    //
    //输入: temperatures = [30,40,50,60]
    //输出: [1,1,1,0]
    //示例 3:
    //
    //输入: temperatures = [30,60,90]
    //输出: [1,1,0]
    //
    //
    //提示：
    //
    //1 <= temperatures.length <= 105
    //30 <= temperatures[i] <= 100

    public static int[] dailyTemperatures(int[] temperatures) {
        if (null == temperatures) {
            return null;
        }
        int length = temperatures.length;
        if (length <= 0) {
            return null;
        }
        //定义返回结果
        int[] res = new int[length];
        //栈结构
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            //循环移除小的
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            //将索引存入
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        //]
        //输出: [1,1,4,2,1,1,0,0]
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }


}
