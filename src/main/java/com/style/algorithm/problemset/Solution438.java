package com.style.algorithm.problemset;

import java.util.*;

/**
 * Find All Anagrams in a String
 * 438. 找到字符串中所有字母异位词
 *
 * @author leon
 * @date 2021-12-23 23:05:11
 */
@SuppressWarnings("all")
public class Solution438 {
    //给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    //
    //异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    //
    //
    //
    //示例1:
    //
    //输入: s = "cbaebabacd", p = "abc"
    //输出: [0,6]
    //解释:
    //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    //示例 2:
    //
    //输入: s = "abab", p = "ab"
    //输出: [0,1,2]
    //解释:
    //起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    //起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    //起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
    //
    //
    //提示:
    //
    //1 <= s.length, p.length <= 3 * 104
    //s和p仅包含小写字母
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }


    public static List<Integer> findAnagrams(String s, String p) {
        if (null == s || "".equals(s)) {
            return null;
        }

        if (null == p || "".equals(p)) {
            return null;
        }
        //构造容器
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //窗口左右索引
        int left = 0, right = 0;
        //有效字符串
        int valid = 0;
        //搜索总长度
        int length = s.length();
        //所需长度
        int needLength = p.length();
        //所需字符串
        int size = need.size();
        //返回结果
        List<Integer> res = new ArrayList<>();
        //默认框架
        while (right < length) {
            char c = s.charAt(right);
            right++;
            //更新窗口
            if (need.containsKey(c)) {
                //更新窗口中 字符大小
                window.put(c, window.getOrDefault(c, 0) + 1);
                Integer actualAmount = window.get(c);
                Integer needAmount = need.get(c);
                if (actualAmount.equals(needAmount)) {
                    valid++;
                }
            }

            //缩小窗口
            while (right - left >= needLength) {
                if (valid == size) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    Integer actualAmount = window.get(c1);
                    Integer needAmount = need.get(c1);
                    if (actualAmount.equals(needAmount)) {
                        valid--;
                    }
                    //更新窗口 中字符的数量
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return res;
    }
}
