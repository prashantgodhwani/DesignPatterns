package Examples.Cache.storage;

import Examples.Cache.Exceptions.KeyNotFoundException;
import Examples.Cache.Exceptions.StorageFullException;

public interface Storage<Key, Value> {

    Value get(Key key) throws KeyNotFoundException;

    void put(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws KeyNotFoundException;
}
