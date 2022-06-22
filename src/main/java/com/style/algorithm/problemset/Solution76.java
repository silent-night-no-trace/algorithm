package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring，
 *
 * @author leon
 * @date 2021-12-22 14:30:20
 */
@SuppressWarnings("all")
public class Solution76 {


    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(16), window = new HashMap<>(16);
        for (Character c : t.toCharArray()) {
            //将t的每个字符都存入map
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //左右索引
        int left = 0, right = 0;
        //开始结束索引
        int start = 0, end = Integer.MAX_VALUE;
        //有效字符串数量
        int valid = 0;
        int length = s.length();
        //所需字符串总数
        int size = need.size();
        while (right < length) {
            System.out.println("第一层left: " + left);
            System.out.println("第一层right: " + right);
            char c = s.charAt(right);
            right++;
            //更新窗口
            if (need.containsKey(c)) {
                //标识当前的字符串是 所需字符串的一个
                //window 窗口计数
                window.put(c, window.getOrDefault(c, 0) + 1);
                Integer needAmount = need.get(c);
                Integer actualAmount = window.get(c);
                if (needAmount.equals(actualAmount)) {
                    //实际数量 = 所需数量
                    //有效数量+1
                    valid++;
                }
            }

            while (valid == size) {
                //窗口内已经包含了 所需的所有字符串
                System.out.println("窗口left: " + left);
                System.out.println("窗口right: " + right);
                if (right - left < end) {
                    start = left;
                    end = right - left;
                    System.out.println("循环中start: " + start);
                    System.out.println("循环中end: " + end);

                }
                //左边开始缩小窗口判断
                char c1 = s.charAt(left);
                //移动左边开始位置
                left++;
                if (need.containsKey(c1)) {
                    Integer needAmount = need.get(c1);
                    Integer actualAmount = window.get(c1);
                    if (needAmount.equals(actualAmount)) {
                        //左滑动的过程 所需要和实际的字符数量相等
                        // 那么 有效数量要-- 为什么要减 因为你向前移动的 移动过去 两者数量不相等了
                        valid--;
                    }
                    //窗口中字符对应的数量-1
                    window.put(c1, window.get(c1) - 1);

                }
            }
        }
        //System.out.println("start: " + start);
        //System.out.println("end: " + end);
        return end == Integer.MAX_VALUE ? "" : s.substring(start, start + end);
    }


    //C++：
    //
    //string s = "HelloWorld";
    //cout << s.substr(4, 4) << endl; // oWor
    //cout << s.substr(4) << endl; // oWorld
    //
    //
    //Java:
    //
    //String s = "HelloWorld";
    //System.out.println(s.substring(4, 8)); // oWor
    //System.out.println(s.substring(4)); // oWorld

    public static void main(String[] args) {
        System.out.println(minWindow("ab", "b"));
        System.out.println(minWindow("abc", "bc"));
        System.out.println(minWindow("bc", "c"));
        System.out.println(minWindow("bbaac", "aba"));

    }

    ;
}
