package com.style.algorithm.problemset;


import java.util.Stack;

/**
 * 316. 去除重复字母
 *
 * @author leon
 * @date 2022-01-04 22:34:16
 */
@SuppressWarnings("all")
public class Solution316 {
    //给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    //
    //注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
    //
    //
    //
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
    //1 <= s.length <= 104
    //s 由小写英文字母组成
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-duplicate-letters
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String removeDuplicateLetters(String s) {
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
        //判断是否是在在栈中
        boolean[] inStack = new boolean[256];
        for (Character c : s.toCharArray()) {
            //操作字符计数器减一
            count[c]--;
            //字符已经存在跳过本次循环
            if (inStack[c]) {
                continue;
            }
            //栈顶的元素大于C 则进行移除
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    //后面不存在该字符 则不能移除
                    break;
                }
                //移除字符 同时设置标记 为不存在 因为已经移除了
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            //该标记为已经存在
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
