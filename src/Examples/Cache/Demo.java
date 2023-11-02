package Examples.Cache;

import Examples.Cache.cache.Cache;
import Examples.Cache.policies.LFUEvictionPolicy;
import Examples.Cache.policies.LRUEvictionPolicy;
import Examples.Cache.storage.HashMapBasedStorage;

public class Demo {

    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(new LFUEvictionPolicy<>(), new HashMapBasedStorage<>(3));
        cache.put(1, "Prashant");
        cache.put(2, "Bla");
        cache.put(3, "test");
        cache.get(1);
        cache.get(1);
        cache.get(3);
        cache.get(3);
        cache.get(2);
        cache.get(2);
        cache.put(4, "BlaBla");

        System.out.println(cache.get(1));
    }
}
