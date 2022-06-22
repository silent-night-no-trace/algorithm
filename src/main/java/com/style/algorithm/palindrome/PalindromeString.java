package com.style.algorithm.palindrome;

import org.apache.commons.lang3.StringUtils;

/**
 * 最大回文字符串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 马拉车 https://segmentfault.com/a/1190000003914228
 * https://www.hackerrank.com/topics/manachers-algorithm
 *
 * @author leon
 * @date 2021-08-03 14:42:28
 */
public class PalindromeString {

    public static String palindrome(String s, int l, int r) {

        char[] chars = s.toCharArray();
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            //向两边展开
            l--;
            r++;
        }

        int begin = l + 1;

        //返回chars[l]到chars[r]的最长回串
        return s.substring(begin, r);
    }

    public static String longestPalindrome(String s) {

        if (StringUtils.isEmpty(s)) {
            return "";
        }
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String palindrome = palindrome(s, i, i);
            String next = palindrome(s, i, i + 1);
            int length = StringUtils.length(result);
            int palindromeLength = StringUtils.length(palindrome);
            int nextLength = StringUtils.length(next);
            result = length > palindromeLength ? result : palindrome;
            result = length > nextLength ? result : next;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("012345543210"));
        System.out.println(longestPalindrome("cdabbacc"));
        System.out.println(longestPalindrome("121"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
