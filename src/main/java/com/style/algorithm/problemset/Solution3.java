package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author leon
 * @date 2021-12-23 23:11:42
 */
@SuppressWarnings("all")
public class Solution3 {
    //给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
    //
    //
    //
    //示例1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    //    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
    //示例 4:
    //
    //输入: s = ""
    //输出: 0
    //
    //
    //提示：
    //
    //0 <= s.length <= 5 * 104
    //s由英文字母、数字、符号和空格组成
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdasdas1easdasdasdasdasd"));
        System.out.println(lengthOfLongestSubstring("abcdsasdasdq1221d"));
        System.out.println(lengthOfLongestSubstring("asdasdada"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        //构造容器
        Map<Character, Integer> window = new HashMap<>();
        //窗口左右索引
        int left = 0, right = 0;
        //搜索总长度
        int length = s.length();
        //结果
        int res = 0;
        //默写框架
        while (right < length) {
            char c = s.charAt(right);
            right++;
            //窗口计数
            window.put(c, window.getOrDefault(c, 0) + 1);

            //缩小窗口
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                window.put(c1, window.get(c1) - 1);
            }
            res = Integer.max(res, right - left);
        }
        return res;
    }

}
