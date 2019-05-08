package com.ten951.consistent;

/**
 * 哈希策略
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:58
 */
public interface HashStrategy {

    int getHashCode(String origin);

}
