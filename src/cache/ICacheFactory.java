package cache;

import cache.exception.PolicyNotSupportedException;

import java.io.Serializable;

public interface ICacheFactory<K, V extends Serializable> {
    Cache<V> GetCache(Policy policy) throws PolicyNotSupportedException;
}