package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * @author leon
 * @date 2021-12-23 21:50:34
 */
@SuppressWarnings("all")
public class Solution567 {

    /**
     * s2中是否包含 s1的排列
     *
     * @param s1 s1
     * @param s2 s2
     * @return boolean
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (null == s1 || "".equals(s1)) {
            return false;
        }
        if (null == s2 || "".equals(s2)) {
            return false;
        }
        //构造容器
        Map<Character, Integer> need = new HashMap<>(16), window = new HashMap<>(16);
        //构造 need
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //左右窗口索引
        int left = 0, right = 0;
        //有效字符
        int valid = 0;
        //s2字符长度 也就搜索最大右边界
        int length = s2.length();
        //查找字符串长度
        int needLength = s1.length();
        //所需字符串
        int size = need.size();

        while (right < length) {
            //右移动
            char c = s2.charAt(right);
            right++;
            //更新窗口
            if (need.containsKey(c)) {
                //增加窗口对应字符数量
                window.put(c, window.getOrDefault(c, 0) + 1);
                Integer actualAmount = window.get(c);
                Integer needAmount = need.get(c);
                if (actualAmount.equals(needAmount)) {
                    //实际数量和所需要的数量相等
                    //有效字符+1
                    valid++;
                }
            }
            //当区间内字符长度大于等于 所需长度时才进行 缩短
            while (right - left >= needLength) {
                if (valid == size) {
                    //有效== 所需字符数量
                    return true;
                }
                char c1 = s2.charAt(left);
                left++;

                if (need.containsKey(c1)) {
                    Integer actualAmount = window.get(c1);
                    Integer needAmount = need.get(c1);
                    if (actualAmount.equals(needAmount)) {
                        valid--;
                    }
                    //扣除 窗口内对应的字符的大小
                    window.put(c1, window.get(c1) - 1);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));

    }
}
