package com.style.algorithm.problemset;

import java.util.LinkedList;

/**
 * 277. 搜寻
 *
 * @author leon
 * @date 2022-02-06 21:01:36
 */
@SuppressWarnings("all")
public class Solution277 {
    //给你 n 个⼈的社交关系（你知道任意两个⼈之间是否认识），然后请你找出这些⼈中的「名⼈」。
    // 所谓「名⼈」有两个条件：
    // 1、所有其他⼈都认识「名⼈」。
    // 2、「名⼈」不认识任何其他⼈。
    // 这是⼀个图相关的算法问题，社交关系嘛，本质上就可以抽象成⼀幅图。 如果把每个⼈看做图中的节点，
    // 「认识」这种关系看做是节点之间的有向边，那么名⼈就是这幅图中⼀个特殊的节点：
    //给你输⼊⼀个⼤⼩为 n x n 的⼆维数组（邻接矩阵） graph 表示⼀幅有 n 个节点的图，
    // 每个⼈都是图中的 ⼀个节点，编号为 0 到 n - 1。 如果 graph[i][j] == 1 代表第 i 个⼈认识第 j 个⼈，
    // 如果 graph[i][j] == 0 代表第 i 个⼈不认识第 j 个⼈。
    // 有了这幅图表示⼈与⼈之间的关系，请你计算，这 n 个⼈中，是否存在「名⼈」？
    // 如果存在，算法返回这个名⼈的编号，如果不存在，算法返回 -1。
    // 函数签名如下：

    /**
     * 可以直接调⽤，能够返回 i 是否认识 j
     *
     * @param i i
     * @param j j
     * @return boolean
     */
    boolean knows(int i, int j) {
        return false;
    }

    /**
     * 暴力穷举 把每个人都视为名人 候选人 在将每个候选人和 其他的候选人 比较 名人认识 候选人 或者 候选人不是认识名人 则这个名人 不是名人
     *
     * @param n n
     * @return int
     */
    int findCelebrity(int n) {
        for (int cand = 0; cand < n; cand++) {
            int other;
            //判断每个候选人和 其他人
            for (other = 0; other < n; other++) {
                if (cand == other) {
                    //相同则跳过
                    continue;
                }
                //其他人认识名人 名人不认识其他人
                if (!knows(other, cand) || knows(cand, other)) {
                    break;
                }
            }
            if (other == n) {
                return cand;
            }
        }
        return -1;
    }

    /**
     * 只要观察任意两个候选⼈的关系，我⼀定能确定其中的⼀个⼈不是名⼈，把他排除。
     * <p>
     * 判断相邻两个候选人 排除一个 最终则会剩下一个
     * <p>
     * 在将最后一个和 其他候选人判断
     *
     * @param n n
     * @return int
     */
    int findCelebrity2(int n) {
        if (1 == n) {
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        while (list.size() >= 2) {
            int candidate = list.removeFirst();
            int other = list.removeFirst();
            if (knows(candidate, other) || !knows(other, candidate)) {
                //candidate 认识其他人 或者 其他人 不认识 candidate  candidate 不可能是名人  other重新入队
                list.addLast(other);
            } else {
                list.addLast(candidate);
            }
        }

        int candidate = list.removeFirst();

        for (int other = 0; other < n; other++) {
            if (candidate == other) {
                continue;
            }
            if (knows(candidate, other) || !knows(other, candidate)) {
                return -1;
            }
        }

        return candidate;
    }


    int findCelebrity3(int n) {
        //假设 candidate 是名人
        int candidate = 0;
        for (int other = 1; other < n; other++) {
            if (knows(candidate, other) || !knows(other, candidate)) {
                candidate = other;
            } else {
                //什么都不做 继续 假设candidate 是名人
            }
        }

        for (int other = 0; other < n; other++) {
            if (other == candidate) {
                continue;
            }
            if (knows(candidate, other) || !knows(other, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

}
