package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 710.黑名单中的随机数
 *
 * @author leon
 * @date 2022-01-13 10:31:31
 */
public class Solution710 {
    //给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
    //
    //对它进行优化使其尽量少调用系统方法 Math.random() 。
    //
    //提示:
    //
    //1 <= n <= 1000000000
    //0 <= blacklist.length < min(100000, N)
    //[0, n)不包含 n ，详细参见interval notation。
    //示例 1：
    //
    //输入：
    //["Solution","pick","pick","pick"]
    //[[1,[]],[],[],[]]
    //输出：[null,0,0,0]
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/random-pick-with-blacklist

    /**
     * 实际有效数组长度
     */
    private int sz;
    private Map<Integer, Integer> mapping;

    public Solution710(int n, int[] blacklist) {
        mapping = new HashMap<>();
        //实际有效数组长度
        sz = n - blacklist.length;
        //记录下黑名单内的元素
        for (int num : blacklist) {
            mapping.put(num, 888);
        }
        //最大索引位置
        int last = n - 1;
        //更新黑名单元素索引
        for (int num : blacklist) {
            if (num >= sz) {
                //黑名单内元素 已经在有效索引范围之外 不管他
                continue;
            }
            //跳过mapping中包含的元素
            while (mapping.containsKey(last)) {
                last--;
            }
            //将元素存入mapping
            mapping.put(num, last);
            System.out.println("mapping put :" + num + " last: " + last);
            //更新最大索引位
            last--;
        }

    }

    public int pick() {
        Random random = new Random();
        int num = random.nextInt(sz);
        int index = num % sz;
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] blackList = {1, 4};
        Solution710 solution710 = new Solution710(5, blackList);
        int pick = solution710.pick();
        System.out.println("pick: " + pick);

    }
}
