package com.style.algorithm.skill;

import java.util.HashMap;

/**
 * @author leon
 * @date 2022-01-05 23:01:02
 */
public class LruCache {
    private final HashMap<Integer, DoubleList.Node> map;
    private final DoubleList cache;
    private int cap;

    public LruCache(int cap) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = cap;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).val;
        }
        return 0;
    }

    public void put(int key, int val) {
        //1.key存在
        if (map.containsKey(key)) {
            //已经存在 更新val 并且 提升为最近使用的key
            map.remove(key);
            map.put(key, new DoubleList.Node(key, val));
            makeRecently(key);
            return;
        }

        if (map.size() >= cap) {
            //容量满了 首先移除 最久未使用元素
            removeLeastRecently();
        }
        addRecently(key, val);
    }

    /**
     * 将某个 key 提升为最近使⽤的
     *
     * @param key key
     */
    public void makeRecently(int key) {
        if (map.containsKey(key)) {
            DoubleList.Node node = map.get(key);
            //先移除
            cache.remove(node);
            //添加到队尾
            cache.addLast(node);
        }
    }

    /**
     * 添加最近使⽤的元素
     *
     * @param key key
     * @param val val
     */
    public void addRecently(int key, int val) {
        DoubleList.Node node = new DoubleList.Node(key, val);
        //添加到队尾
        cache.addLast(node);
        //存入到map
        map.put(key, node);
    }

    /**
     * 删除某⼀个 key
     *
     * @param key key
     */
    private void deleteKey(int key) {
        if (map.containsKey(key)) {
            DoubleList.Node node = map.get(key);
            //链表中移除
            cache.remove(node);
            //map中移除
            map.remove(key);
        }
    }

    /**
     * 删除最久未使⽤的元素
     */
    private void removeLeastRecently() {
        //链表第一个元素 即为最久未使用元素
        DoubleList.Node node = cache.removeFirst();
        //map中移除
        map.remove(node.key);
    }


    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        int val = lruCache.get(1);
        System.out.println("val: " + val);
        lruCache.put(4, 4);
        int val1 = lruCache.get(1);
        System.out.println("val: " + val1);
        int val5 = lruCache.get(4);
        System.out.println("val5: " + val5);
    }

}
