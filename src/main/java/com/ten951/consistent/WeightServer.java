package com.ten951.consistent;

import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 带权重的服务器地址
 *
 * @author Darcy
 * Created By Darcy on 2019-05-16 11:43
 */
@EqualsAndHashCode
@ToString
public final class WeightServer {


    private final String url;
    /**
     * 服务器权重
     */
    private final Integer weight;

    public WeightServer(String url, Integer weight) {
        this.url = url;
        this.weight = weight;
    }


    public Integer getWeight() {
        return weight;
    }

    public String getUrl() {
        return url;
    }
}
