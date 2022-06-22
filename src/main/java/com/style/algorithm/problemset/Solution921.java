package com.style.algorithm.problemset;

/**
 * 921. 使括号有效的最少添加
 *
 * @author leon
 * @date 2021-12-31 09:44:03
 */
public class Solution921 {

    public int minAddToMakeValid(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        //需要插入次数
        int res = 0;
        //所需右括号数量
        int need = 0;
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                //又括号需求加+1
                need++;
            } else if (c.equals(')')) {
                //右括号需求 减一
                need--;
                if (need == -1) {
                    //-1说明 缺小左括号
                    need = 0;
                    //需要插入 左括号
                    res++;
                }
            }

        }
        return need + res;
    }
}
