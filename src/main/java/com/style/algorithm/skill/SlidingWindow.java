package com.style.algorithm.skill;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * @author leon
 * @date 2021-12-22 13:45:16
 */
public class SlidingWindow {

    public void slidingWindow(String s, String t) {
        if (null == t || "".equals(t)) {
            return;
        }
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, 1);
        }
        int left = 0;
        int right = 0;
        int length = s.length();
        while (right < length) {
            char c = s.charAt(right);
            right++;
            //// 进⾏窗⼝内数据的⼀系列更新
            //.....
            // 判断左侧窗⼝是否要收缩
            //while (window needs shrink){
            // d 是将移出窗⼝的字符
            //char d = s.charAt(left);
            // 左移窗⼝
            //left++;
            // 进⾏窗⼝内数据的⼀系列更新
            //...
            // }
        }
    }
}
