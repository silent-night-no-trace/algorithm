package com.style.algorithm.problemset;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @author leon
 * @date 2021-12-27 22:30:27
 */
public class Solution1011 {
    //传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
    //
    //传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
    //
    //返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
    //
    //
    //
    //示例 1：
    //
    //输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
    //输出：15
    //解释：
    //船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
    //第 1 天：1, 2, 3, 4, 5
    //第 2 天：6, 7
    //第 3 天：8
    //第 4 天：9
    //第 5 天：10
    //
    //请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
    //示例 2：
    //
    //输入：weights = [3,2,2,4,1,4], days = 3
    //输出：6
    //解释：
    //船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
    //第 1 天：3, 2
    //第 2 天：2, 4
    //第 3 天：1, 4
    //示例 3：
    //
    //输入：weights = [1,2,3,1,1], D = 4
    //输出：3
    //解释：
    //第 1 天：1
    //第 2 天：2
    //第 3 天：3
    //第 4 天：1, 1
    //
    //
    //提示：
    //
    //1 <= days <= weights.length <= 5 * 104
    //1 <= weights[i] <= 500
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int shipWithinDays(int[] weights, int days) {
        if (null == weights) {
            return 0;
        }
        int length = weights.length;
        if (0 == length) {
            return 0;
        }
        //确认搜索区间
        int left = 0, right = 1;
        for (int w : weights) {
            left = Integer.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 定义f(x) 当载重量为mid时 运载货物所需时间
     *
     * @param weights weights
     * @param mid     mid
     * @return int
     */
    private static int f(int[] weights, int mid) {
        int day = 0;
        for (int i = 0; i < weights.length; ) {
            int x = mid;
            while (i < weights.length) {
                if (x < weights[i]) {
                    break;
                } else {
                    x -= weights[i];
                }
                i++;
            }
            day++;
        }
        return day;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int cap = shipWithinDays(weights, days);
        System.out.println("cap: " + cap);

        int[] weights1 = {3, 2, 2, 4, 1, 4};
        int days1 = 3;
        System.out.println(shipWithinDays(weights1, days1));

    }
}
