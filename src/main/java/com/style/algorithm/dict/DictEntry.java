package com.style.algorithm.dict;

import lombok.Data;

/**
 * hash表节点
 *
 * @author leon
 * @date 2021-08-10 17:51:08
 */
@Data
public class DictEntry {
    // 键
    private String key;

    // 值
    private Object val;

    /**
     * 指向下个哈希表节点，形成链表
     */
    private DictEntry next;
}
