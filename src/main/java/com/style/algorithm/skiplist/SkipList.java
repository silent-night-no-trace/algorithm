package com.style.algorithm.skiplist;

import lombok.Data;

/**
 * @author leon
 * @date 2021-08-12 11:23:28
 */
@Data
public class SkipList {

    /**
     * 表头节点
     */
    private SkipListNode head;

    /**
     * 表尾节点
     */
    private SkipListNode tail;

    /**
     * 表中节点的数量
     */
    private long length;

    /**
     * 表中层数最大的节点的层数
     */
    private int level;

}
