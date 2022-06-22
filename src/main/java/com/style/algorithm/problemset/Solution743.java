package com.style.algorithm.problemset;

import java.util.*;

/**
 * 743. 网络延迟时间
 *
 * @author leon
 * @date 2022-02-03 21:28:58
 */
public class Solution743 {
    //有 n 个网络节点，标记为1到 n。
    //
    //给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
    //
    //现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
    //
    //
    //示例 1：
    //
    //
    //
    //输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    //输出：2
    //示例 2：
    //
    //输入：times = [[1,2,1]], n = 2, k = 1
    //输出：1
    //示例 3：
    //
    //输入：times = [[1,2,1]], n = 2, k = 2
    //输出：-1
    //
    //
    //提示：
    //
    //1 <= k <= n <= 100
    //1 <= times.length <= 6000
    //times[i].length == 3
    //1 <= ui, vi <= n
    //ui != vi
    //0 <= wi <= 100
    //所有 (ui, vi) 对都 互不相同（即，不含重复边）
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/network-delay-time
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * times 记录边和权重，n 为节点个数（从 1 开始），k 为起点
     * 计算从 k 发出的信号⾄少需要多久传遍整幅图
     *
     * @param times 记录边和权重
     * @param n     为节点个数（从 1 开始
     * @param k     为起点
     * @return 计算从 k 发出的信号⾄少需要多久传遍整幅图
     */
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            //// from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].add(new int[]{to, weight});
        }

        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最⻓的那⼀条最短路径
        int res = 0;
        //注意从1开始
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            //更新
            res = Math.max(res, distTo[i]);
        }

        return res;
    }

    private static int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeId = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeId]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeId]) {
                int nextNodeId = neighbor[0];
                int distToNextNode = distTo[curNodeId] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeId] > distToNextNode) {
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }
        return distTo;
    }

    public static class State {
        public int id;
        public int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static void main(String[] args) {
        //times = [[]], n = 2, k = 1
        int[][] times = new int[][]{{1, 2, 1}};
        int i = networkDelayTime(times, 2, 1);
        System.out.println(i);
    }


}
