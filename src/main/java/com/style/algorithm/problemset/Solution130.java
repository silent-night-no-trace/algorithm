package com.style.algorithm.problemset;

import com.style.algorithm.skill.Uf;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 *
 * @author leon
 * @date 2022-01-28 00:18:32
 */
public class Solution130 {
    //你可以把那些不需要被替换的 O 看成⼀个拥有独⻔绝技的⻔派，它们有⼀个共同祖师爷叫 dummy，这些 O 和
    //dummy 互相连通，⽽那些需要被替换的 O 与 dummy 不连通。

    public static void solve(char[][] board) {
        if (null == board || 0 == board.length) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        //给dummy虚拟节点留个空位
        Uf uf = new Uf(m * n + 1);
        int dummy = m * n;
        // 将⾸列和末列的 O 与 dummy 连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }
        // 将首行和末行的 O 与 dummy 连通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                uf.union(n * (m - 1) + j, dummy);
            }
        }

        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // 将此 O 与上下左右的 O 连通{
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    //虚拟节点 没有和该节点连接 则进行替换
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board = new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
