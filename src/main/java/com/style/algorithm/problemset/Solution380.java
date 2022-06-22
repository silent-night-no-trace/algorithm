package com.style.algorithm.problemset;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author leon
 * @date 2022-01-10 22:25:19
 */
public class Solution380 {

    //380. O(1) 时间插入、删除和获取随机元素
    //实现RandomizedSet 类：
    //
    //RandomizedSet() 初始化 RandomizedSet 对象
    //bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
    //bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
    //int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
    //你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。

    private final List<Integer> nums;
    private final Map<Integer, Integer> valToIndex;
    private final Random random = new Random();

    public Solution380() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.putIfAbsent(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        Integer index = valToIndex.get(val);
        //最后一个元素
        Integer last = nums.get(nums.size() - 1);
        //将last元素放到 val对应的索引位置上
        nums.set(index, last);
        //移除最后一个索引位上的元素
        nums.remove(nums.size() - 1);
        //记录 last元素 的索引信息
        valToIndex.put(last, index);
        //移除val对应的 索引关系
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        //["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        //[[],[-1],[-2],[-2],[],[-1],[-2],[]]

        //["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        //[[],[1],[2],[2],[],[1],[2],[]]


        Solution380 randomizedSet = new Solution380();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean insert = randomizedSet.insert(1);
        // 返回 false ，表示集合中不存在 2 。
        boolean remove = randomizedSet.remove(2);
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        boolean insert1 = randomizedSet.insert(2);
        // getRandom 应随机返回 1 或 2 。
        int random = randomizedSet.getRandom();
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        boolean remove1 = randomizedSet.remove(1);
        // 2 已在集合中，所以返回 false 。
        boolean insert2 = randomizedSet.insert(2);
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        int random1 = randomizedSet.getRandom();
        System.out.println("insert: " + insert);
        System.out.println("remove: " + remove);
        System.out.println("insert1: " + insert1);
        System.out.println("random: " + random);
        System.out.println("remove1: " + remove1);
        System.out.println("insert2: " + insert2);
        System.out.println("random1: " + random1);
    }
}
