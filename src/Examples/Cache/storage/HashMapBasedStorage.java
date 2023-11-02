package Examples.Cache.storage;

import Examples.Cache.Exceptions.KeyNotFoundException;
import Examples.Cache.Exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;

    int capacity;

    public HashMapBasedStorage(int capacity){
        storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        if(storage.containsKey(key)){
            return storage.get(key);
        }
        throw new KeyNotFoundException("Key with id " + key + " not found");
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(this.isFull()){
            throw new StorageFullException("Storage full");
        }
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws KeyNotFoundException {
        if (!storage.containsKey(key)) throw new KeyNotFoundException(key + "doesn't exist in cache.");
        storage.remove(key);
    }

    private boolean isFull() {
        return storage.size() == capacity;
    }
}
