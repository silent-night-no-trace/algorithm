package com.style.algorithm.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径
 *
 * @author leon
 * @date 2022-02-04 22:36:51
 */
public class Solution1631 {
    //你准备参加一场远足活动。给你一个二维rows x columns的地图heights，其中heights[row][col]表示格子(row, col)的高度。一开始你在最左上角的格子(0, 0)，且你希望去最右下角的格子(rows-1, columns-1)（注意下标从 0 开始编号）。你每次可以往 上，下，左，右四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
    //
    //一条路径耗费的 体力值是路径上相邻格子之间 高度差绝对值的 最大值决定的。
    //
    //请你返回从左上角走到右下角的最小体力消耗值。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
    //输出：2
    //解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
    //这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
    //示例 2：
    //
    //
    //
    //输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
    //输出：1
    //解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
    //示例 3：
    //
    //
    //输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
    //输出：0
    //解释：上图所示路径不需要消耗任何体力。
    //
    //
    //提示：
    //
    //rows == heights.length
    //columns == heights[i].length
    //1 <= rows, columns <= 100
    //1 <= heights[i][j] <= 106
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/path-with-minimum-effort
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //定义 m n 二维数组 表示从0,0到m,n的所需体力
    //填充数组为 Integer.MAX_VALUE
    //base case effortTo[0][0]= 0
    //定义优先级队列 从小到大排列
    //存入初始值
    //while 队列不为空
    //队列取值
    //是否到达终点  提前返回
    //队列中取出来的State的体力 大于 effortTo[x][y]  continue;
    //获取x,y节点的上下左右相邻节点
    //计算 nextEffortFromStart = Math.max(effortTo[x][y],Math.abs(heights[nextX][nextY]- height[x][y]));
    //effortTo[nextX][nextY] > nextEffortFromStart  更新effortTo[nextX][nextY] = nextEffortFromStart
    //将这个节点加入到队列

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //0,0 到 M,N 所消耗的体力
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;
        //优先级队列 从小到大
        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });
        queue.offer(new State(0, 0, 0));

        while (!queue.isEmpty()) {
            State poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int effortFromStart = poll.effortFromStart;

            if (x == m - 1 && y == n - 1) {
                //提前到达终点 返回
                return effortFromStart;
            }

            if (effortFromStart > effortTo[x][y]) {
                continue;
            }
            for (int[] g : adj(heights, x, y)) {
                int nextX = g[0];
                int nextY = g[1];
                int nextEffortFromStart = Math.max(effortTo[x][y], Math.abs(heights[nextX][nextY] - heights[x][y]));
                if (effortTo[nextX][nextY] > nextEffortFromStart) {
                    //更新 dp
                    effortTo[nextX][nextY] = nextEffortFromStart;
                    queue.offer(new State(nextX, nextY, nextEffortFromStart));
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int[][] heights1 = new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(minimumEffortPath(heights));
        System.out.println(minimumEffortPath(heights1));
    }

    private static List<int[]> adj(int[][] height, int x, int y) {
        int m = height.length;
        int n = height[0].length;
        List<int[]> res = new ArrayList<>();
        //上下左右4个点
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            res.add(new int[]{nx, ny});
        }

        return res;
    }

    static class State {
        public int x, y;
        public int effortFromStart;

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
}
