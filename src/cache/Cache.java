package cache;

import java.io.Serializable;

public interface Cache<V extends Serializable> {
    V Get(java.lang.String k);
    void Put(java.lang.String k, V v);
    void Remove(java.lang.String k);
}
