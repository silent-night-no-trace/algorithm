package com.style.algorithm.problemset;

import com.style.algorithm.model.MultiTreeNode;
import com.style.algorithm.model.TreeNode;
import com.style.algorithm.skill.Uf;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1584. 「连接所有点的最小费用」：
 *
 * @author leon
 * @date 2022-01-30 22:39:47
 */
@SuppressWarnings("all")
public class Solution1584 {
    //很显然这也是一个标准的最小生成树问题：每个点就是无向加权图中的节点，边的权重就是曼哈顿距离，
    // 连接所有点的最小费用就是最小生成树的权重和。
    //
    //所以解法思路就是先生成所有的边以及权重，然后对这些边执行 Kruskal 算法即可：

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //生成边 以及权重
        List<int[]> edges = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        ///从小到大排序
        edges.sort((a, b) -> {
            return a[2] - b[2];
        });
        //执行Kruskal
        Uf uf = new Uf(n);
        //最小生成树 记录值
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }
            mst += weight;
            uf.union(u, v);
        }
        return mst;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int minCostConnectPoints = minCostConnectPoints(points);
        System.out.println(minCostConnectPoints);
    }

    // 输⼊⼀棵⼆叉树的根节点，层序遍历这棵⼆叉树
    public void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        // 从上到下遍历⼆叉树的每⼀层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每⼀层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.printf("节点 %s 在第 %s 层", cur, depth);
                // 将下⼀层节点放⼊队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }
    // 输⼊⼀棵多叉树的根节点，层序遍历这棵多叉树
    public void levelTraverse(MultiTreeNode root) {
        if (root == null) return;
        Queue<MultiTreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        // 从上到下遍历多叉树的每⼀层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每⼀层的每个节点
            for (int i = 0; i < sz; i++) {
                MultiTreeNode cur = q.poll();
                System.out.printf("节点 %s 在第 %s 层", cur, depth);
                // 将下⼀层节点放⼊队列
                for (MultiTreeNode child : cur.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }
}
