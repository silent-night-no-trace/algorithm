package com.style.algorithm.problemset;

import com.style.algorithm.skill.Uf;

import java.util.Arrays;

/**
 * 1135. 最低成本联通所有城市
 *
 * @author leon
 * @date 2022-01-30 21:19:27
 */
@SuppressWarnings("all")
public class Solution1135 {
    //Kruskal 算法
    //所谓最小生成树，就是图中若干边的集合（我们后文称这个集合为mst，最小生成树的英文缩写），你要保证这些边：
    //
    //1、包含图中的所有节点。
    //
    //2、形成的结构是树结构（即不存在环）。
    //
    //3、权重和最小。
    //
    //有之前题目的铺垫，前两条其实可以很容易地利用 Union-Find 算法做到，关键在于第 3 点，如何保证得到的这棵生成树是权重和最小的。
    //
    //这里就用到了贪心思路：
    //
    //将所有边按照权重从小到大排序，从权重最小的边开始遍历，如果这条边和mst中的其它边不会形成环，则这条边是最小生成树的一部分，将它加入mst集合；否则，这条边不是最小生成树的一部分，不要把它加入mst集合。
    //
    //这样，最后mst集合中的边就形成了最小生成树，下面我们看两道例题来运用一下 Kruskal 算法。


    public static int minimumCost(int n, int[][] connections) {
        //从1 开始 所以需要n+1
        Uf uf = new Uf(n + 1);
        //connections 从小到大排序
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        //// 记录最小生成树的权重之和
        int mst = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int weight = connection[2];
            if (uf.connected(u, v)) {
                // 若这条边会产生环，则不能加入 mst
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            uf.union(u, v);
        }
        // 保证所有节点都被连通
        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return uf.count() == 2 ? mst : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        System.out.println(minimumCost(n, connections));
    }
}
