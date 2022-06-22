package com.style.algorithm.skiplist;

import lombok.Data;

/**
 * @author leon
 * @date 2021-08-12 11:23:28
 */
@Data
public class SkipListNode {

    /**
     * 成员对象
     */
    private Object obj;


    /**
     * 分值
     */
    private double score;

    /**
     * 后退指针
     */
    private SkipListNode backward;

    /**
     * 层
     */
    SkipListLevel[] level;
}
