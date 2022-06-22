package com.style.algorithm.problemset;

import java.util.Stack;

/**
 * 1081. 不同字符的最小子序列
 *
 * @author leon
 * @date 2022-01-04 22:33:14
 */
@SuppressWarnings("all")
public class Solution1081 {

    //要求一、要去重。
    //
    //要求二、去重字符串中的字符顺序不能打乱s中字符出现的相对顺序。
    //
    //要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。

    //示例 1：
    //
    //输入：s = "bcabc"
    //输出："abc"
    //示例 2：
    //
    //输入：s = "cbacdcbc"
    //输出："acdb"
    // 
    //
    //提示：
    //
    //1 <= s.length <= 1000
    //s 由小写英文字母组成
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static String smallestSubsequence(String s) {
        if (null == s || "".equals(s)) {
            return null;
        }
        //字符计数器
        int[] count = new int[256];
        for (Character c : s.toCharArray()) {
            count[c]++;
        }
        //栈结构
        Stack<Character> stack = new Stack<>();
        //栈中是否存在 判断
        boolean[] inStack = new boolean[256];
        for (Character c : s.toCharArray()) {
            //操作了元素 计数器减一
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            //保留小的字符在栈中
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    //后续不存在该元素 不能弹出
                    break;
                }
                //后续还存在该元素 弹出
                inStack[stack.pop()] = false;
            }
            //push元素进行判断
            stack.push(c);
            //标记为已存在
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcabc"));
    }

}
