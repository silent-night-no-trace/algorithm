package com.style.algorithm.palindrome;

/**
 * 公共子序列
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484486&idx=1&sn=0bdcb94c6390307ea32427757ec0072c&chksm=9bd7fa4eaca073583623cdb93b05dc9e1d0757b25697bb40b29b3e450124e929ff1a8eaac50f&scene=21#wechat_redirect
 *
 * @author leon
 * @date 2021-08-06 16:28:14
 */
public class CommonSubSequence {

    public static int longestCommonSubSequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("asdfas", "werasdfaswer"));
        System.out.println(longestCommonSubSequence("adas", "adsa"));
    }
}
