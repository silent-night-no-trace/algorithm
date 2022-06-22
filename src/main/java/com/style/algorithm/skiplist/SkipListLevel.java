package com.style.algorithm.skiplist;

import lombok.Data;

/**
 * @author leon
 * @date 2021-08-12 11:27:14
 */
@Data
public class SkipListLevel {
    /**
     * 前进指针
     */
    private SkipListNode forward;

    /**
     * 跨度
     */
    private int span;

}
