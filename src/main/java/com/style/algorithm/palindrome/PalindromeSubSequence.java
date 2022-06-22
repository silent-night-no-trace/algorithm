package com.style.algorithm.palindrome;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 最大回文子序列
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484666&idx=1&sn=e3305be9513eaa16f7f1568c0892a468&chksm=9bd7faf2aca073e4f08332a706b7c10af877fee3993aac4dae86d05783d3d0df31844287104e&scene=21#wechat_redirect
 *
 * @author leon
 * @date 2021-08-03 14:42:28
 */
public class PalindromeSubSequence {


    public static int longestPalindromeSubSequence(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        int n = s.length();
        //定义二维数组
        int[][] dp = new int[n][n];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int j = n - 1; j >= 0; j--) {
            System.out.println("j:: " + j);
            for (int k = j + 1; k < n; k++) {
                System.out.println("k:: " + k);
                if (chars[j] == chars[k]) {
                    dp[j][k] = dp[j + 1][k - 1] + 2;
                } else {
                    dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
                }
            }
        }

        return dp[0][n - 1];

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubSequence("aaaqwqaqw"));
    }

}
