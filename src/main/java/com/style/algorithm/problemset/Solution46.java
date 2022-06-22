package com.style.algorithm.problemset;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author leon
 * @date 2022-02-07 14:16:57
 */
public class Solution46 {

    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //示例 2：
    //
    //输入：nums = [0,1]
    //输出：[[0,1],[1,0]]
    //示例 3：
    //
    //输入：nums = [1]
    //输出：[[1]]
    //
    //
    //提示：
    //
    //1 <= nums.length <= 6
    //-10 <= nums[i] <= 10
    //nums 中的所有整数 互不相同
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/permutations
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    private static List<List<Integer>> res = new LinkedList<>();


    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> path) {
        //触发结束条件
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int num : nums) {
            //排序不符合要求的
            if (path.contains(num)) {
                continue;
            }
            //选择
            path.addLast(num);
            backtrack(nums, path);
            //撤销选择
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
