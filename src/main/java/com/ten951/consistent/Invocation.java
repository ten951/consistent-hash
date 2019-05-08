package com.ten951.consistent;

/**
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:52
 */
public class Invocation {

    public Invocation() {
    }

    public Invocation(String hashKey) {
        this.hashKey = hashKey;
    }

    private String hashKey;

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}
