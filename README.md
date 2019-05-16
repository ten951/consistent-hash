# consistent-hash

## ConsistentHashLoadBalancer

根据不同的HashStrategy, 实现的哈希环

## KetamaConsistentHashLoadBalancer

Ketama 算法有其专门的配套实现方式

## WeightPollingLoadBalancer

平滑的权重轮询算法. 如{a:5,b:1,c:1} 得到的结果为:{a,a,b,a,c,a,a},
避免了高权重服务器一直被使用的问题

## HashCode生成策略

HashStrategy

### CRCHashStrategy 

CRC算法

### FnvHashStrategy

FNV 算法：全名为 Fowler-Noll-Vo 算法，是以三位发明人 Glenn Fowler，Landon Curt Noll，Phong Vo 的名字来命名的，最早在 1991 年提出。

特点和用途：FNV 能快速 hash 大量数据并保持较小的冲突率，它的高度分散使它适用于 hash 一些非常相近的字符串，比如 URL，hostname，文件名，text，IP 地址等。

### KetamaHashStrategy

Ketama 算法：将它称之为哈希算法其实不太准确，称之为一致性哈希算法可能更为合适，其他的哈希算法有通用的一致性哈希算法实现，只不过是替换了哈希方式而已，但 Ketama 是一整套的流程。

### MurmurHashStrategy

MurmurHash 算法：高运算性能，低碰撞率，由 Austin Appleby 创建于 2008 年，现已应用到 Hadoop、libstdc++、nginx、libmemcached 等开源系统。2011 年 Appleby 被 Google 雇佣，随后 Google 推出其变种的 CityHash 算法。官方只提供了 C 语言的实现版本。

Java 界中 Redis，Memcached，Cassandra，HBase，Lucene 都在使用它。

在 Java 的实现，Guava 的 Hashing 类里有，上面提到的 Jedis，Cassandra 里都有相关的 Util 类。

### JdkHashCodeStrategy 

JDK的实现