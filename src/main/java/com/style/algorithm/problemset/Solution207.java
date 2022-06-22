package com.style.algorithm.problemset;

import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 *
 * @author leon
 * @date 2022-01-26 17:18:50
 */
@SuppressWarnings("all")
public class Solution207 {
    //你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
    //
    //在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
    //
    //例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    //请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：numCourses = 2, prerequisites = [[1,0]]
    //输出：true
    //解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    //示例 2：
    //
    //输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    //输出：false
    //解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
    //
    //
    //提示：
    //
    //1 <= numCourses <= 105
    //0 <= prerequisites.length <= 5000
    //prerequisites[i].length == 2
    //0 <= ai, bi < numCourses
    //prerequisites[i] 中的所有课程对 互不相同
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/course-schedule
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 标记是否移动过
     */
    private boolean[] visited;
    /**
     * 移动的路径
     */
    private boolean[] path;
    private boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //创建邻接表
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (path[s]) {
            //路径包含s 即出现环
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            //如果已经记录过 或者 出现环
            return;
        }
        //更新标记 添加路径
        visited[s] = true;
        path[s] = true;
        for (int p : graph[s]) {
            traverse(graph, p);
        }
        //移除路径
        path[s] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        //初始化 邻接表
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }

        return graph;
    }
}
