package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * @author leon
 * @date 2021-12-21 10:59:08
 */
public class Solution560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subArraySum2(nums, k));
    }

    public static int subArraySum(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        //构造前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            //前缀和数据从1开始
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = 0;
        //外层从1开始 故判断 i<=len
        for (int i = 1; i <= len; i++) {
            //内层从0开始 且取<i的所有子数组进行判断
            for (int j = 0; j < i; j++) {
                //计算[j,i-1]
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }

        return res;
    }


    public static int subArraySum2(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        //构造Map
        Map<Integer, Integer> preSum = new HashMap<>(16);
        preSum.put(0, 1);

        int res = 0;
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            //1
            //-2
            //put(1,1);
            //3
            //0
            //res = 1;
            //6
            //3
            //put (6,1)
            System.out.println("sum: " + sum);

            int sumK = sum - k;
            System.out.println("sumK:" + sumK);
            if (preSum.containsKey(sumK)) {
                System.out.println("res之前: " + res);
                res += preSum.get(sumK);
                System.out.println("中:sum: " + sumK);
                System.out.println("中:: " + preSum.get(sumK));
                System.out.println("res之后: " + res);
            }
            //默认要给sum 计数+1
            System.out.println("sum: " + sum);
            System.out.println("key: " + (preSum.getOrDefault(sum, 0) + 1));
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

        }
        return res;
    }

    public static int subArraySum3(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            System.out.println("sum: " + sum);
            int sumK = sum - k;
            System.out.println("sumK:" + (sum - k));
            if (map.containsKey(sumK)) {
                ret += map.get(sumK);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ret;
    }


}

