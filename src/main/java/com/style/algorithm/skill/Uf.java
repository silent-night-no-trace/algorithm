package com.style.algorithm.skill;

/**
 * UNION_FIND
 *
 * @author leon
 * @date 2022-01-27 23:26:49
 */
public class Uf {
    /**
     * 记录连通分量
     */
    private int count;
    /**
     * 记录节点 对应的父节点 节点x 对应的父节点 parent[x]
     */
    private int[] parent;

    /**
     * 新增⼀个数组记录树的“重量”
     */
    private int[] size;

    public Uf(int n) {
        //一开始都不连通
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            //父节点指向自己
            parent[i] = i;
            size[i] = i;
        }
    }

    /**
     * 将 p 和 q 连接
     *
     * @param p p
     * @param q q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        //// 将两棵树合并为⼀棵
        //parent[rootP] = rootQ;
        //平衡性优化
        // ⼩树接到⼤树下⾯，较平衡
        if (size[rootP] > size[rootQ]) {
            //Q拼接到P下面
            parent[rootQ] = rootP;
            //p的重量 增加 q
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        //连通分量-1
        count--;
    }

    /**
     * 返回某个节点 x 的根节点
     *
     * @param p p
     * @return int
     */
    public int find(int p) {
        while (parent[p] != p) {
            //路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }


    /**
     * 判断 p 和 q 是否连通
     *
     * @param p p
     * @param q q
     * @return boolean
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回图中有多少个连通分量
     *
     * @return int
     */
    public int count() {
        return count;
    }
}
