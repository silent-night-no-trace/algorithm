package com.style.algorithm.problemset;

import com.style.algorithm.skill.Uf;

/**
 * 990. 等式方程的可满足性
 *
 * @author leon
 * @date 2022-01-28 00:20:17
 */
public class Solution990 {
    //给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或'"a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
    //
    //只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回'true，否则返回 false。'
    //
    //'
    //
    //示例 1：
    //
    //输入：["a==b","b!=a"]
    //输出：false
    //解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean equationsPossible(String[] equations) {
        //26个字母
        Uf uf = new Uf(26);
        //连接相等的字符
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                //连通
                uf.union(x - 'a', y - 'a');
            }
        }
        //判断不相等字符是否连接
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    //不相等连接了 即冲突了
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] e = {"a==b", "b==c", "a==c"};
        String[] b = {"a==b", "b!=c", "c==a"};
        System.out.println(equationsPossible(e));
        System.out.println(equationsPossible(b));
    }
}
