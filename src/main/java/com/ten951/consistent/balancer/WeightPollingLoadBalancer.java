package com.ten951.consistent.balancer;

import com.ten951.consistent.Invocation;
import com.ten951.consistent.WeightServer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 权重轮询算法
 * @author Darcy
 * Created By Darcy on 2019-05-16 13:50
 */
public class WeightPollingLoadBalancer implements LoadBalancer<WeightServer> {

    private static final ConcurrentMap<WeightServer, AtomicInteger> SERVER_MAP = new ConcurrentHashMap<>();


    @Override
    public WeightServer select(List<WeightServer> servers, Invocation invocation) {
        WeightServer best = null;
        int totalWeight = 0;
        for (WeightServer server : servers) {
            AtomicInteger weightServer = SERVER_MAP.get(server);
            if (null == weightServer) {
                weightServer = new AtomicInteger(0);
                SERVER_MAP.putIfAbsent(server, weightServer);
            }
            int weight = server.getWeight();
            // 加权
            weightServer.addAndGet(weight);
            totalWeight += weight;
            // 根据权选择
            if (null == best || weightServer.get() > SERVER_MAP.get(best).get()) {
                best = server;
            }
        }
        if (null == best) {
            throw new IllegalStateException("can't select client");
        }
        // 降权
        AtomicInteger bestWeightServer = SERVER_MAP.get(best);
        bestWeightServer.set(totalWeight - bestWeightServer.get());
        return best;
    }
}
