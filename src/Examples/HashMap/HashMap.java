package Examples.HashMap;

import Examples.HashMap.models.Bucket;
import Examples.HashMap.models.Node;

import java.util.LinkedList;

public class HashMap<Key, Value> {

    private int bucketLength;

    private final float capacity = 0.75f;

    private int size;

    private Bucket<Key, Value>[] map;

    HashMap(){
        this.bucketLength = 8;
        this.size = 0;
        this.map = new Bucket[bucketLength];
        for(int i = 0; i < bucketLength; i++){
            map[i] = new Bucket<>();
        }
    }

    private int hashCode(Key key){
        return key.hashCode() % bucketLength;
    }

    public void put(Key key, Value value){
        if(size * 1.0 / bucketLength > this.capacity){
            rehash();
        }

        Node<Key, Value> newNode = new Node<>(key, value);
        int hashCode = hashCode(key);
        Bucket<Key, Value> bucket = map[hashCode];
        boolean inserted = bucket.insert(newNode);
            if(inserted) this.size++;
    }

    public Value get(Key key) {
        int index = hashCode(key);
        Bucket<Key, Value> b = this.map[index];
        return b.get(key);
    }

    public void remove(Key key) {
        int index = hashCode(key);
        Bucket<Key, Value> b = this.map[index];
        b.remove(key);
        this.size--;
    }

    private void rehash() {
        int currentSize = this.bucketLength;
        this.bucketLength = currentSize * 2;
        Bucket<Key, Value>[] newMap = new Bucket[bucketLength];
        for(int i = 0; i < bucketLength; i++){
            newMap[i] = new Bucket<>();
        }

        for(int i = 0; i < currentSize; i++){
            LinkedList<Node<Key, Value>> list = map[i].getContainer();
            for(Node<Key, Value> node : list){
                int bucketIdx = hashCode(node.getKey());
                newMap[bucketIdx].insert(node);
            }
        }

        this.map = newMap;
    }

}
