package com.style.algorithm.problemset;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU 缓存
 * 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * @author leon
 * @date 2022-01-06 22:18:51
 */
@SuppressWarnings("all")
public class Solution460 {
    //⼆、思路分析 ⼀定先从最简单的开始，根据 LFU 算法的逻辑，我们先列举出算法执⾏过程中的⼏个显⽽易⻅的事实：
    // 1、调⽤ get(key) ⽅法时，要返回该 key 对应的 val。
    // 2、只要⽤ get 或者 put ⽅法访问⼀次某个 key，该 key 的 freq 就要加⼀。
    // 3、如果在容量满了的时候进⾏插⼊，则需要将 freq 最⼩的 key 删除，如果最⼩的 freq 对应多个 key， 则删除其中最旧的那⼀个。
    // 好的，我们希望能够在 O(1) 的时间内解决这些需求，可以使⽤基本数据结构来逐个击破：

    /**
     * 键值映射
     */
    private HashMap<Integer, Integer> keyToVal;
    /**
     * 键对使用频次 get或者put增加+1
     */
    private HashMap<Integer, Integer> keyToFreq;

    //3、这个需求应该是 LFU 算法的核⼼，所以我们分开说。
    // 3.1、⾸先，肯定是需要 freq 到 key 的映射，⽤来找到 freq 最⼩的 key。
    // 3.2、将 freq 最⼩的 key 删除，那你就得快速得到当前所有 key 最⼩的 freq 是多少。想要时间复杂度 O(1) 的话，肯定不能遍历⼀遍去找，那就⽤⼀个变量 minFreq 来记录当前最⼩的 freq 吧。
    // 3.3、可能有多个 key 拥有相同的 freq，所以 freq 对 key 是⼀对多的关系，即⼀个 freq 对应⼀个 key 的 列表。
    // 3.4、希望 freq 对应的 key 的列表是存在时序的，便于快速查找并删除最旧的 key。
    // 3.5、希望能够快速删除 key 列表中的任何⼀个 key，因为如果频次为 freq 的某个 key 被访问，那么它的 频次就会变成 freq+1，就应该从 freq 对应的 key 列表中删除，加到 freq+1 对应的 key 的列表中。

    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    /**
     * 最小freq
     */
    private int minFreq;

    private final int capacity;

    public Solution460(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加key freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            //重新存入keyToVal
            keyToVal.put(key, value);
            //增加 freq
            increaseFreq(key);
            return;
        }
        //容量校验
        if (capacity <= 0) {
            return;
        }

        if (keyToVal.size() >= capacity) {
            removeMinFreqKey();
        }
        //插入keyToVal
        keyToVal.put(key, value);
        //keyToFreq
        keyToFreq.put(key, 1);
        //添加到 freqToKeys
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        Integer oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        //增加key freq
        keyToFreq.put(key, newFreq);
        //从旧的freqKeys 移除
        LinkedHashSet<Integer> keys = freqToKeys.get(oldFreq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }
        //添加新的freqKeys
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        LinkedHashSet<Integer> newKeys = freqToKeys.get(newFreq);
        newKeys.add(key);
    }

    private void removeMinFreqKey() {
        //移除最少使用的元素
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
        if (null != keys) {
            //相同的freq移除 最旧插入
            Integer next = keys.iterator().next();
            keys.remove(next);
            if (keys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            //更新keyToVal
            keyToVal.remove(next);
            //更新keyToFreq
            keyToFreq.remove(next);
        }
    }

    public static void main(String[] args) {
        Solution460 solution460 = new Solution460(0);
        solution460.put(0, 0);
        System.out.println(solution460.get(0));
    }


}
