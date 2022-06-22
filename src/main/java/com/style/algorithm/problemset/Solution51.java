package com.style.algorithm.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后 Solution51
 *
 * @author leon
 * @date 2022-02-07 21:21:47
 */
public class Solution51 {
    //n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //
    //给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
    //
    //每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    //
    //示例 1：
    //
    //
    //输入：n = 4
    //输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    //解释：如上图所示，4 皇后问题存在两个不同的解法。
    //示例 2：
    //
    //输入：n = 1
    //输出：[["Q"]]
    //
    //
    //提示：
    //
    //1 <= n <= 9
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/n-queens
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //首先明确使用回溯算法 初始化 N*N 的 棋盘 默认 都为 .  char[][] board = new char[n][n];
    //backtrack 从第一行开始放置 对应索引0
    //行数 = N 添加到结果
    //从每行的0开始 到N 进行放置
    //排除掉无效的 因为从上向下添加 我们只用关注 列上 ,左上,右上(int i = row -1,j = col+1;i>=0 && j <= n-1;;i++,j--) 是否冲突
    //放置到 进行选择 board[row][col] = 'Q'
    //递归
    //撤销选择 board[row][col] = '.'

    private static final List<List<String>> res = new LinkedList<>();

    public static List<List<String>> solveNQueens(int n) {
        //定义棋盘
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }

    private static void backtrack(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            res.add(array2List(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                //排除无效的
                continue;
            }
            //选择
            board[row][col] = 'Q';
            //下一行
            backtrack(board, row + 1);
            //撤销选择
            board[row][col] = '.';
        }
    }

    private static List<String> array2List(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] c : board) {
            res.add(String.copyValueOf(c));
        }
        return res;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        //判断行
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        //左上位置判断
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //右上位置判断
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
