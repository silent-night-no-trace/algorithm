package com.style.algorithm.dict;

import lombok.Data;

/**
 * 字典结构
 *
 * @author leon
 * @date 2021-08-10 17:49:34
 */
@Data
public class Dict {

    /**
     * 类型特定函数
     */
    private Integer type;

    /**
     * 私有数据
     */
    private Object privateData;

    /**
     * 哈希表
     */
    private DictHt[] ht = new DictHt[2];


    /**
     * rehash 索引
     * 当 rehash 不在进行时，值为 -1
     * rehashing not in progress if rehashIdx == -1
     */
    private int rehashIdx;

    public static void main(String[] args) {

    }
}
