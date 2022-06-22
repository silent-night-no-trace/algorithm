package com.style.algorithm.problemset;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. 课程表 II
 *
 * @author leon
 * @date 2022-01-26 20:38:05
 */
@SuppressWarnings("all")
public class Solution210 {
    //现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，
    // 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修bi 。
    //
    //例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
    //返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/course-schedule-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //后序遍历的反转即为拓扑排序
    //有图的图 无法进行拓扑排序

    private List<Integer> postOrder = new LinkedList<>();

    private boolean[] path, visited;
    //是否成环
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }
        //反转 后序遍历结果 即为 拓扑排序
        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }

        return res;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (path[s]) {
            //成环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            //结束 或者成环
            return;
        }
        //添加路径 更新标记
        path[s] = true;
        visited[s] = true;
        for (int p : graph[s]) {
            traverse(graph, p);
        }
        //后序遍历位置
        postOrder.add(s);
        //移除路径
        path[s] = false;
    }

    private List<Integer>[] build(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
