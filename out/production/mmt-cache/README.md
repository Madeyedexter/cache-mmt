# Requirements

## In-memory cache.Cache
## Thread safe
## Time complexity
 - Get - O(1)
 - Put - O(1)
 - Capacity - anything
 - Key-value
## Eviction policy
 - Any policy (Take as input)
 - Database/Namespace
## Supported Types for keys
   - int/string/boolean/double
   - < 128 bytes
## Supported types for values
   - serializable

class Person implement Serializeable {}
class Vehicle implem Serializeable{}


interface cache.Cache<K, V> {

    V Get(K key)
}