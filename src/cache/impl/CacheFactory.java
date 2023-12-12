package cache.impl;

import cache.Cache;
import cache.ICacheFactory;
import cache.Policy;
import cache.exception.PolicyNotSupportedException;

import java.io.Serializable;

public class CacheFactory<K, V extends Serializable> implements ICacheFactory {
    @Override
    public Cache<V> GetCache(Policy policy) throws PolicyNotSupportedException {
        switch (policy) {
            case ROUND_ROBIN -> {
                return roundRobinCacheImpl();
            }
            default -> throw new PolicyNotSupportedException("Policy not supported: "+ policy);
        }
    }

    public Cache roundRobinCacheImpl(){
        return new RoundRobinCache<Serializable>();
    }
}
