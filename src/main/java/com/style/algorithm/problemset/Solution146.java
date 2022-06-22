package com.style.algorithm.problemset;

import java.util.LinkedHashMap;

/**
 * 146 LRU 缓存
 *
 * @author leon
 * @date 2022-01-06 21:43:04
 */
public class Solution146 {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public Solution146(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            //缓存大于等于容量
            //移除 最旧的元素
            Integer lastKey = cache.keySet().iterator().next();
            System.out.println("lastKey:" + lastKey);
            cache.remove(lastKey);
        }

        addRecently(key, value);
    }

    private void makeRecently(int key) {
        Integer value = cache.remove(key);
        cache.put(key, value);
    }

    private void addRecently(int key, int val) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, val);
        } else {
            cache.put(key, val);
        }
    }


    public static void main(String[] args) {
        Solution146 solution146 = new Solution146(3);
        solution146.put(1, 1);
        solution146.put(1, 2);
        solution146.put(2, 2);
        solution146.put(3, 3);
        solution146.put(4, 4);
        System.out.println(solution146.get(1));
    }
}
