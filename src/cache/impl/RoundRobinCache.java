package cache.impl;

import cache.Cache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RoundRobinCache<V> implements Cache<Serializable> {

    private final LinkedHashMap<String, Serializable> cache;
    private final int capacity = 1000;

    private final Object readLock;
    private final Object writeLock;

    public RoundRobinCache(){
        cache = new LinkedHashMap<>(1000);
        readLock = new Object();
        writeLock = new Object();
    }

    @Override
    public Serializable Get(java.lang.String k) {
        synchronized (writeLock) {
            return cache.get(k);
        }
    }

    @Override
    public void Put(java.lang.String k, Serializable serializable) {
        if (cache.size() == capacity) {
            Iterator<Map.Entry<String, Serializable>> it = cache.entrySet().iterator();
            it.next();
            it.remove();
        }

        cache.put(k, serializable);
    }

    @Override
    public void Remove(java.lang.String k) {
        cache.remove(k);
    }
}
