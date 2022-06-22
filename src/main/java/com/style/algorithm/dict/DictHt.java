package com.style.algorithm.dict;

import lombok.Data;

/**
 * hash表
 *
 * @author leon
 * @date 2021-08-10 17:49:47
 */
@Data
public class DictHt {
    /**
     * 哈希表数组
     */
    private DictEntry[] table;

    /**
     * 哈希表大小
     */
    private long size;

    /**
     * 哈希表大小掩码，用于计算索引值
     * 总是等于 size - 1
     */
    private long sizeMask;

    /**
     * 该哈希表已有节点的数量
     */
    private long used;
}
