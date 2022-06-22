package com.style.algorithm.skill;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 最不经常使用（LFU）缓存算法设计并实现数据结构
 *
 * @author leon
 * @date 2022-01-07 15:49:23
 */
@SuppressWarnings("all")
public class LfuCache {
    //⼆、思路分析 ⼀定先从最简单的开始，根据 LFU 算法的逻辑，我们先列举出算法执⾏过程中的⼏个显⽽易⻅的事实：
    // 1、调⽤ get(key) ⽅法时，要返回该 key 对应的 val。
    // 2、只要⽤ get 或者 put ⽅法访问⼀次某个 key，该 key 的 freq 就要加⼀。
    // 3、如果在容量满了的时候进⾏插⼊，则需要将 freq 最⼩的 key 删除，如果最⼩的 freq 对应多个 key， 则删除其中最旧的那⼀个。
    // 好的，我们希望能够在 O(1) 的时间内解决这些需求，可以使⽤基本数据结构来逐个击破：


    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;

    //3、这个需求应该是 LFU 算法的核⼼，所以我们分开说。
    // 3.1、⾸先，肯定是需要 freq 到 key 的映射，⽤来找到 freq 最⼩的 key。
    // 3.2、将 freq 最⼩的 key 删除，那你就得快速得到当前所有 key 最⼩的 freq 是多少。想要时间复杂度 O(1) 的话，肯定不能遍历⼀遍去找，那就⽤⼀个变量 minFreq 来记录当前最⼩的 freq 吧。
    // 3.3、可能有多个 key 拥有相同的 freq，所以 freq 对 key 是⼀对多的关系，即⼀个 freq 对应⼀个 key 的 列表。
    // 3.4、希望 freq 对应的 key 的列表是存在时序的，便于快速查找并删除最旧的 key。
    // 3.5、希望能够快速删除 key 列表中的任何⼀个 key，因为如果频次为 freq 的某个 key 被访问，那么它的 频次就会变成 freq+1，就应该从 freq 对应的 key 列表中删除，加到 freq+1 对应的 key 的列表中。

    private Map<Integer, LinkedHashSet<Integer>> freqTokeys;
    private int minFreq;
    private int capacity;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqTokeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加Freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    private void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        //更新 key freq+1
        keyToFreq.put(key, newFreq);
        LinkedHashSet<Integer> keys = freqTokeys.get(oldFreq);
        keys.remove(key);
        if (keys.isEmpty()) {
            //keys 为空移除旧的 freqKeys
            freqTokeys.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }
        //增加到新的 freqKeys
        freqTokeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        LinkedHashSet<Integer> newKeys = freqTokeys.get(newFreq);
        newKeys.add(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (capacity <= 0) {
            return;
        }

        if (keyToVal.size() >= capacity) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqTokeys.putIfAbsent(1, new LinkedHashSet<>());
        LinkedHashSet<Integer> keys = freqTokeys.get(1);
        keys.add(key);
        this.minFreq = 1;
    }

    public void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqTokeys.get(minFreq);
        if (null != keys) {
            Integer next = keys.iterator().next();
            keys.remove(next);
            if (keys.isEmpty()) {
                freqTokeys.remove(minFreq);
            }
            keyToVal.remove(next);
            keyToFreq.remove(next);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */