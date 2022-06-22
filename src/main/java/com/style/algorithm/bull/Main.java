package com.style.algorithm.bull;

import java.util.*;

/**
 * @author leon
 * @date 2022-02-18 21:18:21
 */
public class Main {
    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", 1));
        list.add(new Student("2", 1));
        list.add(new Student("3", 2));
        list.add(new Student("4", 3));

        Student[] students = new Student[3];
        students[0] = new Student("2", 1);
        students[1] = new Student("1", 1);
        students[2] = new Student("3", 2);
        Arrays.sort(students, new Student.Asc());
        System.out.println(Arrays.toString(students));
    }

    static class Student {
        public String name;
        public int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name + " " + grade;
        }

        static class Asc implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.grade - o2.grade;
            }
        }

        static class Desc implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.grade - o1.grade;
            }
        }

    }


    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = in.nextInt();
                }
            }
            solve(board);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println(board[i][8]);
            }
        }
    }

    private static boolean solve(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (!isValid(i, j, k, board)) {
                        continue;
                    }
                    board[i][j] = k;
                    boolean solve = solve(board);
                    if (solve) {
                        return true;
                    }
                    board[i][j] = 0;
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col, int k, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //检查行上是否 重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }
        //检查列上是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }
        //检查3* 3 空间内是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        int endRow = startRow + 3;
        int endCol = startCol + 3;
        if (endRow > m || endCol > n) {
            return false;
        }
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            //迷宫
            int[][] board = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = in.nextInt();
                }
            }

            List<State> path = new ArrayList<>();
            solve(board, 0, 0, path);
            for (State state : path) {
                System.out.println(state.toString());
            }
        }

    }

    private static boolean solve(int[][] board, int x, int y, List<State> path) {
        int m = board.length;
        int n = board[0].length;
        //选择
        path.add(new State(x, y));
        board[x][y] = 1;

        if (x == m - 1 && y == n - 1) {
            //到达结束
            return true;
        }
        //上
        if (x - 1 > -1 && board[x - 1][y] == 0) {
            if (solve(board, x - 1, y, path)) {
                return true;
            }
        }
        //下
        if (x + 1 < m && board[x + 1][y] == 0) {
            if (solve(board, x + 1, y, path)) {
                return true;
            }
        }
        //左
        if (y - 1 > -1 && board[x][y - 1] == 0) {
            if (solve(board, x, y - 1, path)) {
                return true;
            }
        }
        //右
        if (y + 1 < n && board[x][y + 1] == 0) {
            if (solve(board, x, y + 1, path)) {
                return true;
            }
        }

        //撤销选择
        path.remove(path.size() - 1);
        board[x][y] = 0;

        return false;
    }

    static class State {
        public int x;
        public int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] board = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = in.nextInt();
                }
            }
            List<State> path = new ArrayList<>();
            dps(board, 0, 0, path);
            for (State state : path) {
                System.out.println(state.toString());
            }
        }
    }

    private static boolean dps(int[][] board, int x, int y, List<State> path) {
        path.add(new State(x, y));
        board[x][y] = 1;
        int m = board.length;
        int n = board[0].length;
        //base case
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        //上
        if (x - 1 > -1 && board[x - 1][y] == 0) {
            if (dps(board, x - 1, y, path)) {
                return true;
            }
        }

        //下
        if (x + 1 < m && board[x + 1][y] == 0) {
            if (dps(board, x + 1, y, path)) {
                return true;
            }
        }
        //左
        if (y - 1 > -1 && board[x][y - 1] == 0) {
            if (dps(board, x, y - 1, path)) {
                return true;
            }
        }
        //右
        if (y + 1 < n && board[x][y + 1] == 0) {
            if (dps(board, x, y + 1, path)) {
                return true;
            }
        }
        //撤销选择
        path.remove(path.size() - 1);
        board[x][y] = 0;
        return false;

    }
}
