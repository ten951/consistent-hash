package com.ten951.consistent;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一致性哈希均衡器
 *
 * @author Darcy
 * Created By Darcy on 2019-05-08 14:57
 */
public class ConsistentHashLoadBalancer implements LoadBalancer {
    private HashStrategy hashStrategy = new FnvHashStrategy();

    private final static int VIRTUAL_NODE_SIZE = 10;
    private final static String VIRTUAL_NODE_SUFFIX = "&&";

    @Override
    public Server select(List<Server> servers, Invocation invocation) {
        int invocationHashCode = hashStrategy.getHashCode(invocation.getHashKey());
        TreeMap<Integer, Server> ring = buildConsistentHashRing(servers);
        return locate(ring, invocationHashCode);
    }
    private Server locate(TreeMap<Integer, Server> ring, int invocationHashCode) {
        // 向右找到第一个 key
        Map.Entry<Integer, Server> locateEntry = ring.ceilingEntry(invocationHashCode);
        if (locateEntry == null) {
            // 想象成一个环，超过尾部则取第一个 key
            locateEntry = ring.firstEntry();
        }
        return locateEntry.getValue();
    }

    private TreeMap<Integer, Server> buildConsistentHashRing(List<Server> servers) {
        TreeMap<Integer, Server> virtualNodeRing = new TreeMap<>();
        for (Server server : servers) {
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                // 新增虚拟节点的方式如果有影响，也可以抽象出一个由物理节点扩展虚拟节点的类
                virtualNodeRing.put(hashStrategy.getHashCode(server.getUrl() + VIRTUAL_NODE_SUFFIX + i), server);
            }
        }
        return virtualNodeRing;
    }
}
