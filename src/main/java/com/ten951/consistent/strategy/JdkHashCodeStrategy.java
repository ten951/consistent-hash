package com.ten951.consistent.strategy;

import com.ten951.consistent.strategy.HashStrategy;

/**
 * @author Darcy
 * Created By Darcy on 2019-05-08 15:09
 */
public class JdkHashCodeStrategy implements HashStrategy {

    @Override
    public int getHashCode(String origin) {
        return origin.hashCode();
    }
}
