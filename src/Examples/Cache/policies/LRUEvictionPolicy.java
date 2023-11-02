package Examples.Cache.policies;

import Examples.Cache.algorithms.DoublyLinkedList;
import Examples.Cache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        dll = new DoublyLinkedList<>();
        mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detach(mapper.get(key));
            dll.add(mapper.get(key));
        }else{
            DoublyLinkedListNode<Key> node = dll.add(key);
            mapper.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> nodeToBeEvicted = dll.getFirstNode();
        if(nodeToBeEvicted == null) return null;
        return nodeToBeEvicted.getElement();
    }
}
