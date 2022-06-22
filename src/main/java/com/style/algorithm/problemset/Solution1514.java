package com.style.algorithm.problemset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1514. 概率最大的路径
 *
 * @author leon
 * @date 2022-02-05 21:43:53
 */
@SuppressWarnings("all")
public class Solution1514 {
    //给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
    //
    //指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
    //
    //如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
    //输出：0.25000
    //解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
    //示例 2：
    //
    //
    //
    //输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
    //输出：0.30000
    //示例 3：
    //
    //
    //
    //输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
    //输出：0.00000
    //解释：节点 0 和 节点 2 之间不存在路径
    //
    //
    //提示：
    //
    //2 <= n <= 10^4
    //0 <= start, end < n
    //start != end
    //0 <= a, b < n
    //a != b
    //0 <= succProb.length == edges.length <= 2*10^4
    //0 <= succProb[i] <= 1
    //每两个节点之间最多有一条边
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/path-with-maximum-probability
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //构造图 无向图
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            graph[from].add(new double[]{to, prob});
            graph[to].add(new double[]{from, prob});
        }

        //dijkstra算法
        return dijkstra(graph, start, end);
    }

    public static void main(String[] args) {
        //：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
        //
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        double[] sucProb = {0.5, 0.5, 0.2};
        double v = maxProbability(3, edges, sucProb, 0, 2);
        System.out.println(v);
    }

    private static double dijkstra(List<double[]>[] graph, int start, int end) {
        int length = graph.length;
        //// 定义：probTo[i] 的值就是节点 start 到达节点 i 的最⼤概率
        double[] probTo = new double[length];
        //定义取不到的 最小值
        Arrays.fill(probTo, -1);
        //base case
        probTo[start] = 1;
        //降序排
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });
        queue.offer(new State(start, 1));

        while (!queue.isEmpty()) {
            State poll = queue.poll();
            int id = poll.id;
            double probFromStart = poll.probFromStart;
            if (id == end) {
                return probFromStart;
            }
            if (probFromStart < probTo[id]) {
                //已经存在一条 更大概率的路径到达重点
                continue;
            }
            //// 将 curNode 的相邻节点装⼊队列
            for (double[] g : graph[id]) {
                int nextId = (int) g[0];
                // 看看从 curNode 达到 nextNode 的概率是否会更⼤
                double nextProbFromStart = probTo[id] * g[1];
                if (nextProbFromStart > probTo[nextId]) {
                    probTo[nextId] = nextProbFromStart;
                    queue.offer(new State(nextId, nextProbFromStart));
                }
            }

        }

        return 0.0;
    }

    static class State {
        public int id;
        public double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }
}
