package com.style.algorithm.problemset;

/**
 * 261. 以图论树
 *
 * @author leon
 * @date 2022-01-30 21:17:18
 */
public class Solution261 {

    //对于添加的这条边，如果该边的两个节点本来就在同⼀连通分量⾥，那么添加这条边会产⽣环；
    // 反之，如果 该边的两个节点不在同⼀连通分量⾥，则添加这条边不会产⽣环。

    public static boolean validTree(int n, int[][] edges) {
        //初始化 0 - n-1 N个节点
        Uf uf = new Uf(n);
        //// 遍历所有边，将组成边的两个节点进⾏连接
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            //// 若两个节点已经在同⼀连通分量中，会产⽣环
            if (uf.connected(u, v)) {
                return false;
            }
            //// 这条边不会产⽣环，可以是树的⼀部分
            uf.union(u, v);
        }
        /// 要保证最后只形成了⼀棵树，即只有⼀个连通分量
        return uf.count() == 1;
    }

    static class Uf {
        /**
         * 子节点父类
         */
        private int[] parent;
        /**
         * 重量
         */
        private int[] size;
        /**
         * 连通分量
         */
        private int count;

        public Uf(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            //优化树 小数连接到大树下
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                //压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(validTree(n, edges));
    }
}
