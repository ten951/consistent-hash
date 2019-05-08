package com.ten951.consistent;

import java.util.List;

/**
 * 负载均衡器
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:51
 */
public interface LoadBalancer {

    /**
     * @param servers 服务器地址
     * @param invocation
     * @return
     */
    Server select(List<Server> servers, Invocation invocation);
}
