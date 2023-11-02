package Examples.Cache.cache;

import Examples.Cache.Exceptions.KeyNotFoundException;
import Examples.Cache.Exceptions.StorageFullException;
import Examples.Cache.policies.EvictionPolicy;
import Examples.Cache.storage.Storage;

public class Cache<Key, Value>{

    private EvictionPolicy<Key> evictionPolicy;

    private Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public Value get(Key key){
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void put(Key key, Value value){
        try{
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullException exception){
            Key keyToBeRemoved = evictionPolicy.evictKey();
            storage.remove(keyToBeRemoved);
            put(key, value);
        }
    }
}
