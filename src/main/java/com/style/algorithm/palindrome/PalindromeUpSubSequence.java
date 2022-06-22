package com.style.algorithm.palindrome;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Optional;

/**
 * 最大上升子序列
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&idx=1&sn=df58ef249c457dd50ea632f7c2e6e761&chksm=9bd7fa5aaca0734c29bcf7979146359f63f521e3060c2acbf57a4992c887aeebe2a9e4bd8a89&scene=21#wechat_redirect
 *
 * @author leon
 * @date 2021-08-03 14:42:28
 */
public class PalindromeUpSubSequence {


    /**
     * 动态规划设计
     *
     * 动态规划的核心设计思想是数学归纳法。
     * <p>
     * <p>
     * <p>
     * 相信大家对数学归纳法都不陌生，高中就学过，而且思路很简单。比如我们想证明一个数学结论，那么我们先假设这个结论在 k<n 时成立，然后想办法证明 k=n 的时候此结论也成立。如果能够证明出来，那么就说明这个结论对于 k 等于任何数都成立。
     * <p>
     * <p>
     * <p>
     * 类似的，我们设计动态规划算法，不是需要一个 dp 数组吗？我们可以假设 dp[0...i−1] 都已经被算出来了，然后问自己：怎么通过这些结果算出dp[i] ?
     * <p>
     * <p>
     * <p>
     * 直接拿最长递增子序列这个问题举例你就明白了。不过，首先要定义清楚 dp 数组的含义，即 dp[i] 的值到底代表着什么？
     * <p>
     * <p>
     * <p>
     * 我们的定义是这样的：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
     * <p>
     * <p>
     * <p>
     * 举个例子：
     * <p>
     * <p>
     * <p>
     * <img src="https://mmbiz.qpic.cn/mmbiz_png/map09icNxZ4kgXtfMiaNRfjKJK5DiaHNAiaEPb6TvHFjI9Q4ZiaDY7uhI14RIJXUGiaIf0dpic0oN7IEaiazPUPK23SIZQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
     * <img src="https://mmbiz.qpic.cn/mmbiz_png/map09icNxZ4kgXtfMiaNRfjKJK5DiaHNAiaEVoqqLbQqPcQuaH4PNJhsHfpkQUIySgl88W69ePT7AlERVibHHwyib2yQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
     * <img src="https://mmbiz.qpic.cn/mmbiz_gif/b96CibCt70iaZjRayJQVCia5yvdcedgJ5QmIgJLGribw5M569SG75oxjFMqYJSlZED2QxT6l9gyPJJM0KwH18rGLXA/640?tp=webp&wxfrom=5&wx_lazy=1">
     * <p>
     * <p>
     * 算法演进的过程是这样的：图片
     * <p>
     * 根据这个定义，我们的最终结果（子序列的最大长度）应该是 dp 数组中的最大值。
     * <p>
     * <p>
     * <p>
     * int res = 0;
     * for (int i = 0; i < dp.length; i++) {
     * res = Math.max(res, dp[i]);
     * }
     * return res;
     * <p>
     * <p>
     * 读者也许会问，刚才这个过程中每个 dp[i] 的结果是我们肉眼看出来的，我们应该怎么设计算法逻辑来正确计算每个 dp[i] 呢？
     * <p>
     * <p>
     * <p>
     * 这就是动态规划的重头戏了，要思考如何进行状态转移，这里就可以使用数学归纳的思想：
     * <p>
     * <p>
     * <p>
     * 我们已经知道了 dp[0...4] 的所有结果，我们如何通过这些已知结果推出 dp[5] 呢？
     * <p>
     * <p>
     * <p>
     * <img src="https://mmbiz.qpic.cn/mmbiz_png/map09icNxZ4kgXtfMiaNRfjKJK5DiaHNAiaEC6950mgOcEEBicFQzHFjtzbD4BG1TcKrE7GfTP7ZybTyZIFQCq8JI2Q/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1">
     * <p>
     * 根据刚才我们对 dp 数组的定义，现在想求 dp[5] 的值，也就是想求以 nums[5] 为结尾的最长递增子序列。
     * <p>
     * <p>
     * <p>
     * nums[5] = 3，既然是递增子序列，我们只要找到前面那些结尾比 3 小的子序列，然后把 3 接到最后，就可以形成一个新的递增子序列，而且这个新的子序列长度加一。
     * <p>
     * <p>
     * <p>
     * 当然，可能形成很多种新的子序列，但是我们只要最长的，把最长子序列的长度作为 dp[5] 的值即可。
     * <p>
     * <img src="https://mmbiz.qpic.cn/mmbiz_gif/b96CibCt70iaZjRayJQVCia5yvdcedgJ5QmIVe4WdmfkT0DmEweibYq7mP7LiapaJBk2xxhgsjapRXA7pdQRUxo801Q/640?tp=webp&wxfrom=5&wx_lazy=1">
     * <p>
     * 图片
     * <p>
     * <p>
     * <p>
     * 这段代码的逻辑就可以算出 dp[5]。到这里，这道算法题我们就基本做完了。读者也许会问，我们刚才只是算了 dp[5] 呀，dp[4], dp[3] 这些怎么算呢？
     * <p>
     * <p>
     * <p>
     * 类似数学归纳法，你已经可以通过 dp[0...4] 算出 dp[5] 了，那么任意 dp[i] 你肯定都可以算出来：
     * <p>
     * <p>
     * <p>
     * 图片
     * <p>
     * <p>
     * <p>
     * 还有一个细节问题，就是 base case。dp 数组应该全部初始化为 1，因为子序列最少也要包含自己，所以长度最小为 1。下面我们看一下完整代码：
     * <p>
     * <p>
     * <p>
     * 图片
     * <p>
     * <p>
     * <p>
     * 至此，这道题就解决了，时间复杂度 O(N^2)。总结一下动态规划的设计流程：
     * <p>
     * <p>
     * <p>
     * 首先明确 dp 数组所存数据的含义。这步很重要，如果不得当或者不够清晰，会阻碍之后的步骤。
     * <p>
     * <p>
     * <p>
     * 然后根据 dp 数组的定义，运用数学归纳法的思想，假设 dp[0...i−1] 都已知，想办法求出 dp[i]，一旦这一步完成，整个题目基本就解决了。
     * <p>
     * <p>
     * <p>
     * 但如果无法完成这一步，很可能就是 dp 数组的定义不够恰当，需要重新定义 dp 数组的含义；或者可能是 dp 数组存储的信息还不够，不足以推出下一步的答案，需要把 dp 数组扩大成二维数组甚至三维数组。
     *
     * @param ints ints
     * @return int
     */
    public static int longestPalindromeUpSubSequence(int[] ints) {
        int length = ints.length;
        if (length <= 0) {
            return 0;
        }
        Integer[] dp = new Integer[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            System.out.println("i:: " + i);
            for (int j = 0; j < i; j++) {
                System.out.println("j:: " + j);
                if (ints[j] < ints[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Optional<Integer> optional = Lists.newArrayList(dp).stream().max((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            }
            return 0;
        });
        return optional.orElse(1);

    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 4, 5, 23, 4};
        int[] ints2 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(longestPalindromeUpSubSequence(ints2));
        System.out.println(binarySearch(ints2));
    }


    /**
     * 2分查找法
     *
     * @param nums nums
     * @return Integer
     */
    public static Integer binarySearch(int[] nums) {

        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        //牌堆
        int piles = 0;
        int[] dp = new int[length];

        for (int poker : nums) {
            System.out.println("poker: " + poker);
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                System.out.println("[mid]: " + mid);
                System.out.println("dp[mid]: " + dp[mid]);
                if (dp[mid] < poker) {
                    //中间的小于 该张牌 则从mid+1 作为起点位置查找
                    left = mid + 1;
                } else if (dp[mid] > poker) {
                    //中间的大于 该张牌 则将中间的牌作为终点位置查找
                    right = mid;
                } else {
                    right = mid;
                }
            }
            //没有找到合适的牌堆 新建一堆
            if (left == piles) {
                piles++;
            }
            //将这张牌放到堆顶
            dp[left] = poker;
        }
        return piles;
    }
}
