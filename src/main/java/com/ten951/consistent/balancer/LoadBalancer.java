package com.ten951.consistent.balancer;

import com.ten951.consistent.Invocation;
import com.ten951.consistent.Server;

import java.util.List;

/**
 * 负载均衡器
 *
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:51
 */
public interface LoadBalancer<T extends Server> {

    /**
     * 根据负载均衡算法选择最合适的一个Server
     *
     * @param servers    服务器地址集合
     * @param invocation hashKey
     * @return 合适的server
     */
    T select(List<T> servers, Invocation invocation);
}
